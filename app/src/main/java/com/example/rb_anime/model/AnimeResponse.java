package com.example.rb_anime.model;

public class AnimeResponse {

    private String requestHash;
    private boolean requestCached;
    private int requestCacheExpiry;
    private Results results;

    public AnimeResponse(String requestHash, boolean requestCached, int requestCacheExpiry) {
        this.requestHash = requestHash;
        this.requestCached = requestCached;
        this.requestCacheExpiry = requestCacheExpiry;
    }

    public String getRequestHash() {
        return requestHash;
    }

    public void setRequestHash(String requestHash) {
        this.requestHash = requestHash;
    }

    public boolean isRequestCached() {
        return requestCached;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public void setRequestCached(boolean requestCached) {
        this.requestCached = requestCached;
    }

    public int getRequestCacheExpiry() {
        return requestCacheExpiry;
    }

    public void setRequestCacheExpiry(int requestCacheExpiry) {
        this.requestCacheExpiry = requestCacheExpiry;
    }
}
