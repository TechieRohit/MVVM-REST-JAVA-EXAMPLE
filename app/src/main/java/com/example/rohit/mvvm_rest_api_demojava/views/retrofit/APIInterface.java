package com.example.rohit.mvvm_rest_api_demojava.views.retrofit;

import com.example.rohit.mvvm_rest_api_demojava.views.models.NewsSource;
import com.example.rohit.mvvm_rest_api_demojava.views.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

   /* @GET(Constants.NEWS_SOURCE)
    Call<List<NewsSource>> getNewsSource();*/

   @GET(Constants.NEWS_SOURCE)
    Call<NewsSource> getNewsSource();
}
