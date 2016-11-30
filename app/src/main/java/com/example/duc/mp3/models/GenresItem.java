package com.example.duc.mp3.models;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;

/**
 * Created by DUC on 26/11/2016.
 */

public class GenresItem {
    private String title;
    private int imageId;

    public GenresItem(String title, int imageId) {
        this.title = title;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return imageId;
    }

    public static final List<GenresItem> list = new ArrayList<GenresItem>();
}
