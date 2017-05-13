package com.example.duc.mp3.utils;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.example.duc.mp3.MainActivity;
import com.example.duc.mp3.managers.Preferences;
import com.google.android.exoplayer.DecoderInfo;
import com.google.android.exoplayer.ExoPlayer;
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer;
import com.google.android.exoplayer.MediaCodecSelector;
import com.google.android.exoplayer.MediaCodecUtil;
import com.google.android.exoplayer.extractor.ExtractorSampleSource;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DefaultAllocator;
import com.google.android.exoplayer.upstream.DefaultUriDataSource;
import com.google.android.exoplayer.util.Util;

/**
 * Created by DUC on 14/12/2016.
 */

public class Exo {
    private static final int BUFFER_SEGMENT_SIZE = 64 * 1024;
    private static final int BUFFER_SEGMENT_COUNT = 256;
    private static final String TAG = MainActivity.class.toString();
    private static MediaCodecAudioTrackRenderer audioRenderer;
    private static Exo instance;
    public static final ExoPlayer player = ExoPlayer.Factory.newInstance(1);

    public Exo(Context context){
    }

    public void play(String url, Context context) {
        player.seekTo(0);
        Uri radioUri = Uri.parse(url);
        Allocator allocator = new DefaultAllocator(BUFFER_SEGMENT_SIZE);
        String userAgent = Util.getUserAgent(context, "ExoPlayerDemo");
        DataSource dataSource = new DefaultUriDataSource(context, null, userAgent);
        MediaCodecSelector mediaCodecSelector = MediaCodecSelector.DEFAULT;
        ExtractorSampleSource sampleSource = new ExtractorSampleSource(
                radioUri, dataSource, allocator, BUFFER_SEGMENT_SIZE * BUFFER_SEGMENT_COUNT);
        audioRenderer = new MediaCodecAudioTrackRenderer(sampleSource, mediaCodecSelector);
        player.prepare(audioRenderer);
        Log.d(TAG, "play" + player.getPlayWhenReady());
        player.setPlayWhenReady(true);
    }

    public static Exo getInstance(){
        return instance;
    }

    public static void init(Context context){
        instance = new Exo(context);
    }

}
