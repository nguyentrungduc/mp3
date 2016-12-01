package com.example.duc.mp3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duc.mp3.managers.DbContext;
import com.example.duc.mp3.models.GenresItem;

/**
 * Created by DUC on 01/12/2016.
 */

public class PlayListGenreAdapter extends RecyclerView.Adapter<PlayListGenreViewHolder>{


    @Override
    public PlayListGenreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.play_list_genre, parent, false);
        PlayListGenreViewHolder playListGenreViewHolder = new PlayListGenreViewHolder(itemView);
        return playListGenreViewHolder;
    }

    @Override
    public void onBindViewHolder(PlayListGenreViewHolder holder, int position) {
        GenresItem genresItem = DbContext.getInstance().findAllFavorite().get(position);
        holder.setData(genresItem);

    }

    @Override
    public int getItemCount() {
        return DbContext.getInstance().findAllFavorite().size();
    }
}
