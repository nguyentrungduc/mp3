package com.example.duc.mp3.jsonmodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DUC on 30/11/2016.
 */

public class JsonInfo {
    @SerializedName("im:name")
    private Label name;
    @SerializedName("im:image")
    private List<Label> image;
    @SerializedName("im:artist")
    private Label artist;

    public Label getName() {
        return name;
    }

    public List<Label> getImage() {
        return image;
    }

    public Label getArtist() {
        return artist;
    }

    public JsonInfo(Label name, List<Label> image, Label artist) {
        this.name = name;
        this.image = image;
        this.artist = artist;
    }
}
