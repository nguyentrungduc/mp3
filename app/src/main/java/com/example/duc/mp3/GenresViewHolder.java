package com.example.duc.mp3;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duc.mp3.models.GenresItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DUC on 26/11/2016.
 */

public class GenresViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.genres_Iv)
    ImageView genresiv;
    @BindView(R.id.genres_Tv)
    TextView genrestv;

    public GenresViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(GenresItem genresItem){
        genrestv.setText(genresItem.getTitle());
        genresiv.setImageResource(genresItem.getImageId());
    }
}
