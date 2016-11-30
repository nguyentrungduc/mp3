package com.example.duc.mp3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duc.mp3.models.GenresItem;

/**
 * Created by DUC on 26/11/2016.
 */

public class GenresAdapter extends RecyclerView.Adapter<GenresViewHolder> {

    @Override
    public GenresViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.genres_item, parent, false);

        GenresViewHolder genresViewHolder = new GenresViewHolder(itemView);
        return genresViewHolder;
    }

    @Override
    public void onBindViewHolder(GenresViewHolder holder, int position) {
        GenresItem genresItem = GenresItem.list.get(position);
        holder.setData(genresItem);

    }

    @Override
    public int getItemCount() {
        return GenresItem.list.size();
    }
}
