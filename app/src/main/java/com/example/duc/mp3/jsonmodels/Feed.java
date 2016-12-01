package com.example.duc.mp3.jsonmodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DUC on 30/11/2016.
 */

public class Feed {
    @SerializedName("entry")
    private List<JsonInfo> jsonInfoList;

    public List<JsonInfo> getJsonInfoList() {
        return jsonInfoList;
    }

    public Feed(List<JsonInfo> jsonInfoList) {
        this.jsonInfoList = jsonInfoList;
    }
}
