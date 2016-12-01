package com.example.duc.mp3.models;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;

/**
 * Created by DUC on 26/11/2016.
 */

public class GenresItem extends RealmObject{
    private String title;
    private int imageId;
    private String id;
    private Boolean isFavorite = false;

    public GenresItem(String title, int imageId) {
        this.title = title;
        this.imageId = imageId;
    }

    public GenresItem(String title, int imageId, String id, Boolean isFavorite) {
        this.title = title;
        this.imageId = imageId;
        this.id = id;
        this.isFavorite = isFavorite;
    }

    public GenresItem(String title, int imageId, String id) {
        this.title = title;
        this.imageId = imageId;
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static List<GenresItem> getList() {
        return list;
    }

    public GenresItem() {
    }

    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return imageId;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean favorite) {
        isFavorite = favorite;
    }

    public static List<GenresItem> list = new ArrayList<GenresItem>();
}