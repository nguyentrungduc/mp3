package com.example.duc.mp3.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DUC on 30/11/2016.
 */

public class JsonMedia {
    @SerializedName("id")
    private  int id;
    @SerializedName("translation_key")
    private String translation_key;

    public JsonMedia(int id, String translation_key) {
        this.id = id;
        this.translation_key = translation_key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTranslation_key() {
        return translation_key;
    }

    public void setTranslation_key(String translation_key) {
        this.translation_key = translation_key;
    }
}
