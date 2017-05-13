package com.example.duc.mp3.jsonmodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DUC on 03/12/2016.
 */
public class Docs {
    @SerializedName("numFound")
    String numfound;

    public String getNumfound() {
        return numfound;
    }

    @SerializedName("docs")
    private List<TopSong> topSongList;

    public Docs(List<TopSong> topSongList) {
        this.topSongList = topSongList;
    }

    public List<TopSong> getTopSongList() {
        return topSongList;
    }
}
