package com.example.rb_anime.repo.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    // https://api.jikan.moe/v3/search/anime?q=cowboybebop

    @GET("/search/anime")
    Call<List<String>> getAnime(@Query("q") String anime);
}
