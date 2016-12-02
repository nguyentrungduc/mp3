package com.example.duc.mp3;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.duc.mp3.http.GENREService;
import com.example.duc.mp3.jsonmodels.FeedFather;
import com.example.duc.mp3.jsonmodels.JsonInfo;
import com.example.duc.mp3.managers.DbContext;
import com.example.duc.mp3.managers.NetWorkManager;
import com.example.duc.mp3.managers.Preferences;
import com.example.duc.mp3.models.GenresItem;
import com.example.duc.mp3.models.TopSongItem;

import java.util.List;

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
public class DetailGenreFragment extends Fragment {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.genre_Iv)
    ImageView genreiv;
    @BindView(R.id.name_tv)
    TextView nametv;
    @BindView(R.id.top_song_Rv)
    RecyclerView topsongrv;
    @BindView(R.id.favorite_Iv)
    ImageView favoriteiv;
    @BindView(R.id.btn_Play)
    ImageView btnPlay;
    @BindView(R.id.btn_Back)
    ImageView btnBack;

    private TopSongAdapter topSongAdapter;



    public DetailGenreFragment() {
        // Required empty public constructor
    }
    int index = Preferences.getInstance().getIndexTouch();
    List<GenresItem> genresItems = DbContext.getInstance().findAll();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_genre, container, false);
        ButterKnife.bind(this, view);
        addListener();
        topSongAdapter = new TopSongAdapter(getContext());
        setupUI();
        setup();
        return view;
    }

    private void setupUI() {
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        btnPlay.setLayoutParams(new RelativeLayout.LayoutParams(3 * width / 10,width / 5));
        btnPlay.setY(height / 9 * 4 - width / 10 - height / 20);
        btnPlay.setX(3 * width / 5);
        genreiv.setImageResource(genresItems.get(index).getImageId());
        nametv.setText(genresItems.get(index).getTitle());
        if(DbContext.getInstance().findAll().get(index).getFavorite()){
            favoriteiv.setColorFilter(Color.parseColor("#F44336"));
        }
    }

    private void setup(){
        if(NetWorkManager.getInstance().isConnectedToInternet()){
            get();
        }
        else{
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            topsongrv.setLayoutManager(layoutManager);
            topsongrv.setAdapter(topSongAdapter);
        }
    }

    private void get() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.GENRE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GENREService service = retrofit.create(GENREService.class);

        service.callFeed(genresItems.get(index).getId()).enqueue(new Callback<FeedFather>() {
            @Override
            public void onResponse(Call<FeedFather> call, Response<FeedFather> response) {
                List<JsonInfo> jsonInfos = response.body().getFeed().getJsonInfoList();

                for(JsonInfo jsonInfo : jsonInfos){
                    String name, artist, image;
                    name = jsonInfo.getName().getStrLabel();
                    artist = jsonInfo.getArtist().getStrLabel();
                    image = jsonInfo.getImage().get(1).getStrLabel();
                    TopSongItem topSongItem =
                            new TopSongItem(image, name, artist);
                    TopSongItem.list.add(topSongItem);
                    topSongAdapter.notifyDataSetChanged();
                }


                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                topsongrv.setLayoutManager(layoutManager);
                topsongrv.setAdapter(topSongAdapter);
                if(DbContext.getInstance().check(genresItems.get(index).getId()) == true){
                    for(JsonInfo jsonInfo : jsonInfos){
                        String name, artist, image;
                        name = jsonInfo.getName().getStrLabel();
                        artist = jsonInfo.getArtist().getStrLabel();
                        image = jsonInfo.getImage().get(1).getStrLabel();
                        TopSongItem topSongItemOffline =
                                new TopSongItem(image, name, artist,genresItems.get(index).getId());
                        DbContext.getInstance().addTopSong(topSongItemOffline);
                    }
                    Log.d(TAG,DbContext.getInstance().findAllTopSong().size()+ "jji");

                }

            }

            @Override
            public void onFailure(Call<FeedFather> call, Throwable t) {
                Log.d(TAG,t.toString());

            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        TopSongItem.list.clear();
    }

    private void addListener(){
        favoriteiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(DbContext.getInstance().findAll().get(index).getFavorite() == false) {
                    favoriteiv.setColorFilter(Color.parseColor("#F44336"));
                    GenresItem genresItem = DbContext.getInstance().findAll().get(index);
                    DbContext.getInstance().changeFavorite(genresItem);
                    PlaylistFragment.playListGenreAdapter.notifyDataSetChanged();

                }
                else{
                    favoriteiv.setColorFilter(Color.parseColor("#00FFFFFF"));
                    GenresItem genresItem = DbContext.getInstance().findAll().get(index);
                    DbContext.getInstance().changeNoFavorite(genresItem);
                    PlaylistFragment.playListGenreAdapter.notifyDataSetChanged();
                }

            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
