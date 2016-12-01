package com.example.duc.mp3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duc.mp3.models.PlayListItem;

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
        PlayListItem playListItem = PlayListItem.list.get(position);
        holder.setData(playListItem);

    }

    @Override
    public int getItemCount() {
        return PlayListItem.list.size();
    }
}
