package com.example.duc.mp3.jsonmodels;

import java.util.ArrayList;

/**
 * Created by DUC on 26/11/2016.
 */

public class Subgenres {
    ArrayList<JsonMedia> jsonMedias;

    public Subgenres(ArrayList<JsonMedia> jsonMedias) {
        this.jsonMedias = jsonMedias;
    }

    public ArrayList<JsonMedia> getJsonMedias() {
        return jsonMedias;
    }

    public void setJsonMedias(ArrayList<JsonMedia> jsonMedias) {
        this.jsonMedias = jsonMedias;
    }
}
