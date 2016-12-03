package com.example.duc.mp3;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duc.mp3.models.GenresItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DUC on 01/12/2016.
 */

public class PlayListGenreViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.play_list_genre_Tv)
    TextView playlistgenretv;
    @BindView(R.id.playplist_Iv)
    ImageView playlistiv;

    public PlayListGenreViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(GenresItem genresItem){
        playlistgenretv.setText(genresItem.getTitle());
        playlistiv.setImageResource(genresItem.getImageId());
    }
}
