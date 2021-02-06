package com.example.rb_anime.repo;

import com.example.rb_anime.model.AnimeSearchResponse;

import retrofit2.Call;

public class AnimeRepository {

    private static AnimeRepository INSTANCE = null;

    private AnimeRepository() {

    }

    public Call<AnimeSearchResponse> getAnimeList(String animeTitle) {
        return RetrofitInstance.getInstance().getAnimeList(animeTitle);
    }

    public static AnimeRepository getInstance() {
        if(INSTANCE == null)
            INSTANCE = new AnimeRepository();
        return INSTANCE;
    }

}
