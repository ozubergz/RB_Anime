package com.example.rb_anime.repo;

import com.example.rb_anime.model.AnimeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    // https://api.jikan.moe/v3/search/anime?q=cowboybebop

    @GET("search/anime")
    Call<AnimeResponse> getAnime(@Query("q") String anime);
}
