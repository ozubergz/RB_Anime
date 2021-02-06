package com.example.rb_anime.model;

import java.util.List;

public class AnimeSearchResponse {

    private List<AnimeModel> results;

    public AnimeSearchResponse(List<AnimeModel> results) {
        this.results = results;
    }

    public List<AnimeModel> getAnimeModels() {
        return results;
    }

    public void setAnimeModels(List<AnimeModel> results) {
        this.results = results;
    }
}
