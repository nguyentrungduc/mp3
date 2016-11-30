package com.example.duc.mp3.http;

import com.example.duc.mp3.jsonmodels.Jsonmp3;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DUC on 26/11/2016.
 */

public interface MP3Service {
    @GET("/data/media-types.json")
    Call<Jsonmp3[]> getObject();
}
