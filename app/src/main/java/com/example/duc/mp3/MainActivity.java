package com.example.duc.mp3;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.duc.mp3.http.MP3Service;
import com.example.duc.mp3.jsonmodels.JsonMedia;
import com.example.duc.mp3.jsonmodels.Jsonmp3;
import com.example.duc.mp3.jsonmodels.Subgenres;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        get();

    }

    private void setupUI() {

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("GENRES"));
        tabLayout.addTab(tabLayout.newTab().setText("PLAYLIST"));
        tabLayout.addTab(tabLayout.newTab().setText("OFFLINE"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
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
                Log.d(TAG,"ONR");
                Jsonmp3[] jsonmp3s = response.body();
                Jsonmp3 jsonmp3 = jsonmp3s[3];
                Subgenres subgenres = jsonmp3.getSubgenres();
                ArrayList<JsonMedia> jsonMedias = subgenres.getJsonMedias();
                for(JsonMedia jsonMedia : jsonMedias){
                    Log.d(TAG, String.valueOf(jsonMedia.getId()));
                }
            }

            @Override
            public void onFailure(Call<Jsonmp3[]> call, Throwable t) {
                Log.d(TAG,"ONF");
                Log.d(TAG,t.toString());

            }
        });

    }




}

