package com.example.duc.mp3.http;

import com.example.duc.mp3.jsonmodels.Feed;
import com.example.duc.mp3.jsonmodels.FeedFather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by DUC on 30/11/2016.
 */

public interface GENREService {
    @GET("/us/rss/topsongs/limit=50/genre={id}/explicit=true/json")
    Call<FeedFather> callFeed(@Path("id")String string);

}
