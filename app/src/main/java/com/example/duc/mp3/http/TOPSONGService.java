package com.example.duc.mp3.http;

import com.example.duc.mp3.jsonmodels.Docs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by DUC on 03/12/2016.
 */

public interface TOPSONGService {
    @GET("/api/mobile/search/song")
    Call<Docs> callDocs(@Query("requestdata") String string);
//    @GET("/api/mobile/search/song?requestdata={\"q\":\"{hihi}\", \"sort\":\"hot\", \"start\":\"0\", \"length\":\"10\"")
//    Call<DocsFather> callDocs(@Path("hihi")String string);
}
