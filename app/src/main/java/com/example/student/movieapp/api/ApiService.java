package com.example.student.movieapp.api;

import com.example.student.movieapp.models.MovieResult;
import com.example.student.movieapp.models.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by USER on 9/30/2017.
 */

public interface ApiService {
    @GET("movie/popular")
    Call<MoviesResponse> getPopularMovies(@Query("api_key") String apikey);

    @GET("movie/top_rated")
    Call<MovieResult> getTopRatedMovies(@Query("api_key") String apikey);
}


