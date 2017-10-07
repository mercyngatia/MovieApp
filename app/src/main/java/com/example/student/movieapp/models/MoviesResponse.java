package com.example.student.movieapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by USER on 9/30/2017.
 */

public class MoviesResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Movie> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public Integer getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public List<Movie> getResults() {
        return results;
    }
    public List<Movie> getMovies() {
        return results;
    }
    public void setResults(List<Movie> results) {
        this.results = results;
    }
    public void setMovies(List<Movie> results) {
        this.results = results;
    }
    public int getTotalResults() {
        return totalResults;
    }
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }
    public Integer getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }


}
