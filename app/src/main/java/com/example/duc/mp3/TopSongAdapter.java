package com.example.duc.mp3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duc.mp3.models.TopSongItem;

/**
 * Created by DUC on 01/12/2016.
 */

public class TopSongAdapter extends RecyclerView.Adapter<TopSongViewHolder> {

    Context context;

    public TopSongAdapter(Context context) {
        this.context = context;
    }

    @Override
    public TopSongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.top_song_item, parent, false);
        TopSongViewHolder topSongViewHolder = new TopSongViewHolder(itemView);
        return topSongViewHolder;
    }

    @Override
    public void onBindViewHolder(TopSongViewHolder holder, int position) {
        TopSongItem topSongItem = TopSongItem.list.get(position);
        holder.setData(topSongItem, context);

    }


    @Override
    public int getItemCount() {
        return TopSongItem.list.size();
    }
}
