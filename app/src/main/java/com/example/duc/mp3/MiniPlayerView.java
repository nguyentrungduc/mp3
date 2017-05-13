package com.example.duc.mp3;

import android.app.FragmentTransaction;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.duc.mp3.managers.Preferences;
import com.example.duc.mp3.utils.Exo;
import com.example.duc.mp3.utils.Utils;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DUC on 13/12/2016.
 */

public class MiniPlayerView extends LinearLayout {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.mini_Seekbar)
    SeekBar miniseekbar;
    @BindView(R.id.image_miniplayer)
    ImageView imageminiplayer;
    @BindView(R.id.btn_miniplayer)
    ImageView btnminiplayer;
    @BindView(R.id.tv_art_miniplayer)
    TextView tvartminiplayer;
    @BindView(R.id.tv_name_miniplayer)
    TextView tvnameminiplayer;

    public MiniPlayerView(Context context) {
        super(context);
        initialize();
        addListenner(context);
    }

    public MiniPlayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
        addListenner(context);
    }

    public MiniPlayerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
        addListenner(context);
    }

    private void initialize() {
        ViewGroup viewGroup = (ViewGroup)inflate(getContext(), R.layout.miniplayer_view, this);
        ButterKnife.bind(this, viewGroup);
    }

    public void setUp(String name, String art, String url,Context context){
        tvnameminiplayer.setText(name);
        tvartminiplayer.setText(art);
        Picasso.with(context).load(url).into(imageminiplayer);
        btnminiplayer.setImageResource(R.drawable.ic_pause_circle_outline_black_24px);
        imageminiplayer.startAnimation(AnimationUtils.loadAnimation(context,R.anim.rotate));

    }

    public void addListenner(final Context context){
        btnminiplayer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Preferences.getInstance().getIsPlaying()){
                    btnminiplayer.setImageResource(R.drawable.ic_play_arrow_black_24px);
                    Exo.player.setPlayWhenReady(false);
                    Preferences.getInstance().putIsPlaying(false);
                    Log.d(TAG, Preferences.getInstance().getIsPlaying().toString()+"dsvrs");
                }
                else{
                    btnminiplayer.setImageResource(R.drawable.ic_pause_circle_outline_black_24px);
                    Exo.player.setPlayWhenReady(true);
                    Preferences.getInstance().putIsPlaying(true);
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        onTouchEvent(ev);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        
        return super.onTouchEvent(event);
    }
}
