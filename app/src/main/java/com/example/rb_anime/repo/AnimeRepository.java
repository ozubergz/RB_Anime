package com.example.rb_anime.repo;



import com.example.rb_anime.model.AnimeDetailModel;
import com.example.rb_anime.model.AnimeSearchResponse;

import io.reactivex.Observable;
import retrofit2.Call;

public class AnimeRepository {

    private static AnimeRepository INSTANCE = null;

    private AnimeRepository() {

    }

    public Observable<AnimeSearchResponse> getAnimeSearchList(String animeTitle) {
        Observable<AnimeSearchResponse> response = RetrofitInstance.getInstance().getAnimeSearchList(animeTitle);
        return response;
    }

    public Call<AnimeSearchResponse> getTopAnimeList(String type, int page, String subtype) {
        return RetrofitInstance.getInstance().getTopAnimeList(type, page, subtype);
    }

    public Call<AnimeDetailModel> getAnimeDetail(int id) {
        return RetrofitInstance.getInstance().getAnimeDetail(id);
    }

    public static AnimeRepository getInstance() {
        if(INSTANCE == null)
            INSTANCE = new AnimeRepository();
        return INSTANCE;
    }

}
