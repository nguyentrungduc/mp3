package com.example.duc.mp3;


import com.example.duc.mp3.jsonmodels.TopSong;
import com.example.duc.mp3.models.TopSongItem;

/**
 * Created by DUC on 03/12/2016.
 */
public class EventClass {
    private TopSongItem topSongItem;
    private String urlPlay;

    public TopSongItem getTopSongItem() {
        return topSongItem;
    }

    public EventClass(TopSongItem topSongItem, String urlPlay) {
        this.topSongItem = topSongItem;
        this.urlPlay = urlPlay;
    }

    public String getUrlPlay() {
        return urlPlay;
    }

    public EventClass(TopSongItem topSongItem) {
        this.topSongItem = topSongItem;
    }

    public EventClass(){
    }


}
