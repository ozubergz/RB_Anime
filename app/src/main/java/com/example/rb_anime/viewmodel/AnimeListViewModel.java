package com.example.rb_anime.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rb_anime.model.AnimeModel;
import com.example.rb_anime.model.AnimeSearchResponse;
import com.example.rb_anime.repo.AnimeRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeListViewModel extends ViewModel {
    private final MutableLiveData<List<AnimeModel>> _animeModels = new MutableLiveData<>();

    public LiveData<List<AnimeModel>> getAnimeModels() {
        return _animeModels;
    }

    private final AnimeRepository animeRepo = AnimeRepository.getInstance();

    public void fetchAnimeList(String animeTitle) {
        animeRepo.getAnimeList(animeTitle).enqueue(new Callback<AnimeSearchResponse>() {
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
}
