package com.example.duc.mp3.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DUC on 30/11/2016.
 */

public class JsonMedia {
    @SerializedName("id")
    private String id;
    @SerializedName("translation_key")
    private String translation_key;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTranslation_key() {
        return translation_key;
    }

    public void setTranslation_key(String translation_key) {
        this.translation_key = translation_key;
    }
}
