package com.example.samachar;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    String Base_url="https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<MainNews> getnews(
            @Query("country") String country_name,
            @Query("pageSize") int total_result,
            @Query("apiKey") String api_key
    );
    @GET("top-headlines")
    Call<MainNews> getcategorynews(
            @Query("country") String country_name,
            @Query("category") String category_news,
            @Query("pageSize") int total_result,
            @Query("apiKey") String api_key
            );
}
