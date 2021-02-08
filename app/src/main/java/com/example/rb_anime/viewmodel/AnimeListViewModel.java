package com.example.rb_anime.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rb_anime.model.AnimeDetailModel;
import com.example.rb_anime.model.AnimeModel;
import com.example.rb_anime.model.AnimeSearchResponse;
import com.example.rb_anime.model.TopAnimeModel;
import com.example.rb_anime.repo.AnimeRepository;
import com.example.rb_anime.view.AnimeDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeListViewModel extends ViewModel {
    private final MutableLiveData<List<AnimeModel>> _animeModels = new MutableLiveData<>();
    private final MutableLiveData<List<TopAnimeModel>> _topAnimes = new MutableLiveData<>();
    private final MutableLiveData<TopAnimeModel> _firstTopAnimes = new MutableLiveData<>();
    public final MutableLiveData<AnimeDetailModel> _anime = new MutableLiveData<>();

    public LiveData<List<AnimeModel>> getAnimeModels() {
        return _animeModels;
    }
    public LiveData<List<TopAnimeModel>> getTopAnimes() { return  _topAnimes; }
    public LiveData<TopAnimeModel> getFirstTopAnime() { return _firstTopAnimes; }
    public LiveData<AnimeDetailModel> getAnime() { return _anime; }

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
                TopAnimeModel firstTopAnime = topAnimes.get(0);
                _firstTopAnimes.setValue(firstTopAnime);
                _topAnimes.setValue(topAnimes);
            }

            @Override
            public void onFailure(Call<AnimeSearchResponse> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

    public void fetchAnimeDetail(int id) {
        animeRepo.getAnimeDetail(id).enqueue(new Callback<AnimeDetailModel>() {
            @Override
            public void onResponse(Call<AnimeDetailModel> call, Response<AnimeDetailModel> response) {
                AnimeDetailModel anime = response.body();
                _anime.setValue(anime);
            }

            @Override
            public void onFailure(Call<AnimeDetailModel> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

}
