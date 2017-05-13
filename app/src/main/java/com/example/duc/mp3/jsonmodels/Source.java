package com.example.duc.mp3.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DUC on 13/12/2016.
 */
public class Source {
    @SerializedName("128")
    private String link;

    public String getLink() {
        return link;
    }
}
