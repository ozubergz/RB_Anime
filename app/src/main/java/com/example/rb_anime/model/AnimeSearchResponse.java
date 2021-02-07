package com.example.rb_anime.model;

import java.util.List;

public class AnimeSearchResponse {

    private List<AnimeModel> results;
    private List<TopAnimeModel> top;

    public AnimeSearchResponse(List<AnimeModel> results, List<TopAnimeModel> top) {
        this.top = top;
        this.results = results;
    }

    public List<AnimeModel> getAnimeModels() {
        return results;
    }

    public void setAnimeModels(List<AnimeModel> results) {
        this.results = results;
    }

    public List<TopAnimeModel> getTop() {
        return top;
    }

    public void setTop(List<TopAnimeModel> top) {
        this.top = top;
    }
}
