package com.example.rb_anime.repo;

import com.example.rb_anime.repo.remote.RetrofitInstance;

import java.util.List;

import retrofit2.Call;

public class AnimeRepository {

    private static AnimeRepository INSTANCE = null;

    private AnimeRepository() {

    }

    public Call<List<String>> getAnimeList(String anime) {
        return RetrofitInstance.getInstance().getAnime(anime);
    }

    public static AnimeRepository getInstance() {
        if(INSTANCE == null)
            INSTANCE = new AnimeRepository();
        return INSTANCE;
    }

}
