package com.example.duc.mp3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duc.mp3.managers.DbContext;
import com.example.duc.mp3.managers.NetWorkManager;
import com.example.duc.mp3.models.GenresItem;

/**
 * Created by DUC on 26/11/2016.
 */

public class GenresAdapter extends RecyclerView.Adapter<GenresViewHolder> {

    Context context;

    public GenresAdapter(Context context){
        this.context = context;
    }

    @Override
    public GenresViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.genres_item, parent, false);

        GenresViewHolder genresViewHolder = new GenresViewHolder(itemView);
        return genresViewHolder;
    }

    @Override
    public void onBindViewHolder(GenresViewHolder holder, int position) {
        if(NetWorkManager.getInstance().isConnectedToInternet()) {
            GenresItem genresItem = GenresItem.list.get(position);
            holder.setData(genresItem, context);

        }
        else{
            GenresItem genresItem = DbContext.getInstance().findAll().get(position);
            holder.setData(genresItem, context);
        }

    }

    @Override
    public int getItemCount() {
        if(NetWorkManager.getInstance().isConnectedToInternet()) {
            return GenresItem.list.size();
        }
        else
            return DbContext.getInstance().findAll().size();
    }
}
