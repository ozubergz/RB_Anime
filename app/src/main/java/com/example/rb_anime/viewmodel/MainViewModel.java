package com.example.rb_anime.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rb_anime.model.AnimeResponse;
import com.example.rb_anime.repo.AnimeRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<String> _animeTitle = new MutableLiveData<>();

    public LiveData<String> getAnimeTitle() { return _animeTitle; }

    public void setAnimeTitle(String title) { _animeTitle.setValue(title); }

    private final AnimeRepository animeRepo = AnimeRepository.getInstance();

    public void fetchAnimeList(String animeTitle) {
        animeRepo.getAnimeList(animeTitle).enqueue(new Callback<AnimeResponse>() {
            @Override
            public void onResponse(Call<AnimeResponse> call, Response<AnimeResponse> response) {

            }

            @Override
            public void onFailure(Call<AnimeResponse> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
