package com.example.rb_anime.model;

import com.squareup.moshi.Json;

import java.io.Serializable;

public class AnimeModel {

    @Json(name = "mal_id")
    private int malId;
    private String url;
    @Json(name = "image_url")
    private String imageUrl;
    private String title;
    @Json(name = "title_japanese")
    private String titleJapanese;
    private boolean airing;
    private String synopsis;
    private String type;
    private Integer episodes;
    private Double score;
    @Json(name = "start_date")
    private String startDate;
    @Json(name = "end_date")
    private String endDate;
    private int members;
    private String rated;

    public AnimeModel(int malId, String url, String imageUrl, String title, String titleJapanese, boolean airing, String synopsis, String type, int episodes, double score, String startDate, String endDate, int members, String rated) {
        this.malId = malId;
        this.url = url;
        this.imageUrl = imageUrl;
        this.title = title;
        this.titleJapanese = titleJapanese;
        this.airing = airing;
        this.synopsis = synopsis;
        this.type = type;
        this.episodes = episodes;
        this.score = score;
        this.startDate = startDate;
        this.endDate = endDate;
        this.members = members;
        this.rated = rated;
    }

    public int getMalId() {
        return malId;
    }

    public void setMalId(int malId) {
        this.malId = malId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAiring() {
        return airing;
    }

    public void setAiring(boolean airing) {
        this.airing = airing;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getTitleJapanese() {
        return titleJapanese;
    }

    public void setTitleJapanese(String titleJapanese) {
        this.titleJapanese = titleJapanese;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
