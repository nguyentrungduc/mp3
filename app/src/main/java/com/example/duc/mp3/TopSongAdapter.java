package com.example.duc.mp3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duc.mp3.managers.DbContext;
import com.example.duc.mp3.managers.NetWorkManager;
import com.example.duc.mp3.managers.Preferences;
import com.example.duc.mp3.models.TopSongItem;

/**
 * Created by DUC on 01/12/2016.
 */

public class TopSongAdapter extends RecyclerView.Adapter<TopSongViewHolder> {

    private static final String TAG = MainActivity.class.toString();
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
        if(NetWorkManager.getInstance().isConnectedToInternet()) {
            TopSongItem topSongItem = TopSongItem.list.get(position);
            holder.setData(topSongItem, context);
        }
        else{
            TopSongItem topSongItem =
                    DbContext.getInstance().
                            findTopSongByID(Preferences.getInstance().getIDTouch())
                            .get(position);
            holder.setData(topSongItem, context);
        }
    }


    @Override
    public int getItemCount() {
        if (NetWorkManager.getInstance().isConnectedToInternet()) {

            return TopSongItem.list.size();
        }
        else {
            Log.d(TAG,  "hihi");
            return DbContext.getInstance().
                    findTopSongByID(Preferences.getInstance().getIDTouch()).size();
        }


    }
}
