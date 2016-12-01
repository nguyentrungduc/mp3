package com.example.duc.mp3.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DUC on 30/11/2016.
 */

public class FeedFather {
    @SerializedName("feed")
    private Feed feed;

    public FeedFather(Feed feed) {
        this.feed = feed;
    }

    public Feed getFeed() {
        return feed;
    }
}
