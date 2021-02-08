package com.example.rb_anime.repo;

import com.example.rb_anime.model.AnimeDetailModel;
import com.example.rb_anime.model.AnimeSearchResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {

    // https://api.jikan.moe/v3/search/anime?q=cowboybebop

    @GET("search/anime")
    Observable<AnimeSearchResponse> getAnimeSearchList(@Query("q") String anime);

    @GET("top/{type}/{page}/{subtype}")
    Call<AnimeSearchResponse> getTopAnimeList(
            @Path(value = "type", encoded = true) String type, @Path(value = "page", encoded = true) int page, @Path(value = "subtype", encoded = true) String subtype);

    @GET("anime/{id}")
    Call<AnimeDetailModel> getAnimeDetail(@Path(value = "id", encoded = true) int id);
}
