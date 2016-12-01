package com.example.duc.mp3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duc.mp3.models.TopSongItem;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DUC on 01/12/2016.
 */

public class TopSongViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.top_name_song_Tv)
    TextView topnamesongtv;
    @BindView(R.id.artics_top_song)
    TextView articstopsong;
    @BindView(R.id.topsong_Iv)
    ImageView topsongiv;


    public TopSongViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(TopSongItem topSongItem, Context context){
        topnamesongtv.setText(topSongItem.getName());
        articstopsong.setText(topSongItem.getArtist());
        Picasso.with(context).load(topSongItem.getUrlImage()).into(topsongiv);

    }
}
