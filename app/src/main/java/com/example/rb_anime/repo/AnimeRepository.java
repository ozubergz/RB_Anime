package com.example.rb_anime.repo;

import com.example.rb_anime.model.AnimeSearchResponse;

import retrofit2.Call;

public class AnimeRepository {

    private static AnimeRepository INSTANCE = null;

    private AnimeRepository() {

    }

    public Call<AnimeSearchResponse> getAnimeSearchList(String animeTitle) {
        return RetrofitInstance.getInstance().getAnimeSearchList(animeTitle);
    }

    public Call<AnimeSearchResponse> getTopAnimeList(String type, int page, String subtype) {
        return RetrofitInstance.getInstance().getTopAnimeList(type, page, subtype);
    }

    public static AnimeRepository getInstance() {
        if(INSTANCE == null)
            INSTANCE = new AnimeRepository();
        return INSTANCE;
    }

}
