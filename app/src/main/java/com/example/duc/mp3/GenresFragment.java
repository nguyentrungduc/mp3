package com.example.duc.mp3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duc.mp3.http.MP3Service;
import com.example.duc.mp3.jsonmodels.JsonMedia;
import com.example.duc.mp3.jsonmodels.Jsonmp3;
import com.example.duc.mp3.managers.DbContext;
import com.example.duc.mp3.managers.NetWorkManager;
import com.example.duc.mp3.managers.Preferences;
import com.example.duc.mp3.models.GenresItem;
import com.example.duc.mp3.utils.Utils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class GenresFragment extends Fragment {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.genres_Cv)
    RecyclerView genrescv;
    GenresAdapter genresAdapter;


    public GenresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_genres, container, false);
        ButterKnife.bind(this,view);
        get();
        setupUI();
        return view;
    }



    private void setupUI() {
        genresAdapter = new GenresAdapter(getContext());
        final GridLayoutManager manager = new
                GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position % 3 == 0 ? 2 : 1);
            }

        });

        genresAdapter.notifyDataSetChanged();
        genrescv.setLayoutManager(manager);
        genrescv.setAdapter(genresAdapter);
        genrescv.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), genrescv ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d(TAG, String.valueOf(position));
                        Preferences.getInstance().putIndexTouch(position);
                        String s = DbContext.getInstance().findAll().get(position).getId();
                        Preferences.getInstance().putIDTouch(s);
                        final FragmentTransaction ft = getFragmentManager().beginTransaction().addToBackStack(null);
                        ft.replace(R.id.genre_Rl, new DetailGenreFragment());
                        ft.commit();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );
    }

    private void get() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.MP3_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MP3Service service = retrofit.create(MP3Service.class);
        service.getObject().enqueue(new Callback<Jsonmp3[]>() {
            @Override
            public void onResponse(Call<Jsonmp3[]> call, Response<Jsonmp3[]> response) {
                Log.d(TAG, "ONR");
                Jsonmp3[] jsonmp3s = response.body();
                Jsonmp3 jsonmp3 = jsonmp3s[3];

                ArrayList<JsonMedia> jsonMedias = jsonmp3.getSubgenres();
                for (JsonMedia jsonMedia : jsonMedias) {
                    Log.d(TAG, String.valueOf(GenresItem.list.size()));
                    GenresItem genresItem = new GenresItem(jsonMedia.getTranslation_key(),
                            Utils.GetIdByName("genre_"+jsonMedia.getId(),getContext()),jsonMedia.getId());
                    GenresItem.list.add
                            (genresItem);
                    genresAdapter.notifyDataSetChanged();
                }
                if(DbContext.getInstance().getSize() == 0){
                    for (JsonMedia jsonMedia : jsonMedias) {
                        GenresItem genresItem = new GenresItem(jsonMedia.getTranslation_key(),
                                Utils.GetIdByName("genre_"+jsonMedia.getId(),getContext())
                                ,jsonMedia.getId(),false);
                        DbContext.getInstance().add(genresItem);
                    }

                }
            }

            @Override
            public void onFailure(Call<Jsonmp3[]> call, Throwable t) {
                Log.d(TAG, "ONF");
                Log.d(TAG, t.toString());

            }
        });



    }
}
