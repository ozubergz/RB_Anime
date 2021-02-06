package com.example.rb_anime.repo;

import com.example.rb_anime.model.AnimeSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    // https://api.jikan.moe/v3/search/anime?q=cowboybebop

    @GET("search/anime")
    Call<AnimeSearchResponse> getAnimeList(@Query("q") String anime);
}
