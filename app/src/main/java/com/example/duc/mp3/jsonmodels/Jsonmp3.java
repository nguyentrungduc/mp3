package com.example.duc.mp3.jsonmodels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by DUC on 26/11/2016.
 */

public class Jsonmp3 {
    @SerializedName("id")
    private String id;

    public String getId() {
        return id;
    }

    @SerializedName("subgenres")
    private ArrayList<JsonMedia> subgenres;

    public ArrayList<JsonMedia> getSubgenres() {
        return subgenres;
    }
}
