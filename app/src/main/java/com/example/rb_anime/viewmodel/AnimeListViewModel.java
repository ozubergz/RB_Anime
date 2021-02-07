package com.example.rb_anime.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rb_anime.model.AnimeModel;
import com.example.rb_anime.model.AnimeSearchResponse;
import com.example.rb_anime.model.TopAnimeModel;
import com.example.rb_anime.repo.AnimeRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeListViewModel extends ViewModel {
    private final MutableLiveData<List<AnimeModel>> _animeModels = new MutableLiveData<>();
    private final MutableLiveData<List<TopAnimeModel>> _topAnimes = new MutableLiveData<>();

    public LiveData<List<AnimeModel>> getAnimeModels() {
        return _animeModels;
    }
    public LiveData<List<TopAnimeModel>> getTopAnimes() { return  _topAnimes; }

    private final AnimeRepository animeRepo = AnimeRepository.getInstance();

    public void fetchAnimeSearchList(String animeTitle) {
        animeRepo.getAnimeSearchList(animeTitle).enqueue(new Callback<AnimeSearchResponse>() {
            @Override
            public void onResponse(Call<AnimeSearchResponse> call, Response<AnimeSearchResponse> response) {
                AnimeSearchResponse JSONResponse = response.body();
                List<AnimeModel> animeModels = JSONResponse.getAnimeModels();
                _animeModels.setValue(animeModels);
            }

            @Override
            public void onFailure(Call<AnimeSearchResponse> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

    public void fetchTopAnimeList(String type, int page, String subtype) {
        animeRepo.getTopAnimeList(type, page, subtype).enqueue(new Callback<AnimeSearchResponse>() {
            @Override
            public void onResponse(Call<AnimeSearchResponse> call, Response<AnimeSearchResponse> response) {
                AnimeSearchResponse JSONResponse = response.body();
                List<TopAnimeModel> topAnimes = JSONResponse.getTop();
                _topAnimes.setValue(topAnimes);
            }

            @Override
            public void onFailure(Call<AnimeSearchResponse> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
