package com.foreks.chucknorrisjokes.services;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ozan on 29/03/17.
 */

public interface APIService {

    String API_URL = "https://api.chucknorris.io/";

    @GET("jokes/categories")
    Call<List<String>> fetchCategories();
}
