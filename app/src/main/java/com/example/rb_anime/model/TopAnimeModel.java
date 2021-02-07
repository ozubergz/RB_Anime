package com.example.rb_anime.model;

import com.squareup.moshi.Json;

import java.io.Serializable;

public class TopAnimeModel implements Serializable {

    @Json(name = "mal_id")
    private int malId;
    private int rank;
    private String title;
    private String url;
    @Json(name = "image_url")
    private String imageUrl;
    private String type;
    private Integer episodes;
    @Json(name = "start_date")
    private String startDate;
    @Json(name = "end_date")
    private String endDate;
    private int members;
    private double score;

    public TopAnimeModel(int malId, int rank, String title, String url, String imageUrl, String type, Integer episodes, String startDate, String endDate, int members, double score) {
        this.malId = malId;
        this.rank = rank;
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
        this.type = type;
        this.episodes = episodes;
        this.startDate = startDate;
        this.endDate = endDate;
        this.members = members;
        this.score = score;
    }

    public int getMalId() {
        return malId;
    }

    public void setMalId(int malId) {
        this.malId = malId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
