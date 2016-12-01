package com.example.duc.mp3.models;

import android.provider.ContactsContract;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;

/**
 * Created by DUC on 01/12/2016.
 */

public class TopSongItem extends RealmObject {

    private String urlImage;
    private String name;
    private String artist;
    private String id;


    public String getId() {
        return id;
    }

    public TopSongItem(String urlImage, String name, String artist) {
        this.urlImage = urlImage;
        this.name = name;
        this.artist = artist;
    }

    public TopSongItem(String urlImage, String name, String artist, String id) {
        this.urlImage = urlImage;
        this.name = name;
        this.artist = artist;
        this.id = id;
    }

    public TopSongItem() {
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public TopSongItem(String artist, String name) {
        this.artist = artist;
        this.name = name;
    }

    public static final List<TopSongItem> list = new ArrayList<TopSongItem>();
}
