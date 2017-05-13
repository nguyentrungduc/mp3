package com.example.duc.mp3;

import android.app.FragmentTransaction;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.duc.mp3.managers.Preferences;
import com.example.duc.mp3.models.TopSongItem;
import com.example.duc.mp3.utils.Exo;

import com.google.android.exoplayer.MediaCodecAudioTrackRenderer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;



import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    //@BindView(R.id.miniplay_view)
    MiniPlayerView miniplayerview;
    private  MediaCodecAudioTrackRenderer audioRenderer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        Preferences.init(this);
        ButterKnife.bind(this);
        miniplayerview = (MiniPlayerView) findViewById(R.id.miniplay_view);
        setupUI();

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

    @Subscribe
    public void onEvent(EventClass eventClass){
        TopSongItem topSongItem = eventClass.getTopSongItem();
        miniplayerview.setVisibility(View.VISIBLE);
        miniplayerview.setUp(topSongItem.getName(),
                topSongItem.getArtist(), topSongItem.getUrlImage(), this);
        String urlStream = eventClass.getUrlPlay();
        Exo.getInstance().play(urlStream, this);
    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }



}





