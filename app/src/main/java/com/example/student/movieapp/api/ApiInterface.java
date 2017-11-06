package com.example.student.movieapp.api;

import com.example.student.movieapp.models.MovieResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by USER on 7/22/2017.
 */

public interface ApiInterface{

    @GET("movie/popular")
    Call<MovieResult> getPopularMovies(@Query("api_key") String apikey);

    @GET("movie/top_rated")
    Call<MovieResult> getTopRatedMovies(@Query("api_key") String apikey);
}
