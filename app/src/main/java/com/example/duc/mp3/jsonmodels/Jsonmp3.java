package com.example.duc.mp3.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DUC on 26/11/2016.
 */

public class Jsonmp3 {
    @SerializedName("subgenres")
    private Subgenres subgenres;

    public Subgenres getSubgenres() {
        return subgenres;
    }
}
