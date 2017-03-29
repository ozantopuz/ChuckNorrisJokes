package com.foreks.chucknorrisjokes.services;
import com.foreks.chucknorrisjokes.models.RandomJokeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ozan on 29/03/17.
 */

public interface APIService {

    String API_URL = "https://api.chucknorris.io/";

    @GET("jokes/categories")
    Call<List<String>> fetchCategories();

    @GET("jokes/random")
    Call<RandomJokeResponse> fetchRandomJoke(@Query("category") String mCategory);
}
