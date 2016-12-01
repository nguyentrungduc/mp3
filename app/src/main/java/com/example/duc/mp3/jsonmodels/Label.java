package com.example.duc.mp3.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DUC on 30/11/2016.
 */
public class Label {
    @SerializedName("label")
    private String strLabel;

    public Label(String strLabel) {
        this.strLabel = strLabel;
    }

    public String getStrLabel() {
        return strLabel;
    }
}
