package com.example.duc.mp3.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DUC on 03/12/2016.
 */

public class TopSong {
    @SerializedName("title")
    private String title;

    @SerializedName("artist")
    private String artist;

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public LinkDowload getLinkDowload() {
        return linkDowload;
    }

    @SerializedName("link_download")
    private LinkDowload linkDowload;

    @SerializedName("source")
    private Source source;

    public Source getSource() {
        return source;
    }
}
