package com.example.duc.mp3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.duc.mp3.managers.DbContext;
import com.example.duc.mp3.managers.Preferences;
import com.example.duc.mp3.models.GenresItem;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlaylistFragment extends Fragment {

    @BindView(R.id.genre_playlist_Rv)
    RecyclerView genrelistrv;

    public static PlayListGenreAdapter playListGenreAdapter = new PlayListGenreAdapter();


    private static final String TAG = MainActivity.class.toString();

    public PlaylistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_playlist, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        addListener();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        genrelistrv.setAdapter(playListGenreAdapter);
        playListGenreAdapter.notifyDataSetChanged();
    }


    private void setupUI(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        genrelistrv.setLayoutManager(layoutManager);
    }

    private void addListener(){
        genrelistrv.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), genrelistrv ,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                GenresItem genresItem = DbContext.
                                        getInstance().findAllFavorite().get(position);
                                String id = genresItem.getId();
                                int i = 0;
                                for(GenresItem genresItem1 : DbContext.getInstance().findAll()){
                                    if(genresItem1.getId().equals(id)){
                                        Preferences.getInstance().putIndexTouch(i);
                                    }
                                    i++;
                                }
                                final FragmentTransaction ft =
                                        getFragmentManager().beginTransaction().addToBackStack(null);
                                ft.replace(R.id.play_list_Rl, new DetailGenreFragment());
                                ft.commit();

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }
                        }));
    }

}
