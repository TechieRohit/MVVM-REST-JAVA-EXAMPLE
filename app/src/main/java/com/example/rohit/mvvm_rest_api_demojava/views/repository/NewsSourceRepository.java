package com.example.rohit.mvvm_rest_api_demojava.views.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.widget.Toast;

import com.example.rohit.mvvm_rest_api_demojava.views.models.Article;
import com.example.rohit.mvvm_rest_api_demojava.views.models.NewsSource;
import com.example.rohit.mvvm_rest_api_demojava.views.retrofit.APIClient;
import com.example.rohit.mvvm_rest_api_demojava.views.retrofit.APIInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsSourceRepository {

    MutableLiveData<List<Article>> newsSourceList = new MutableLiveData<>();
    NewsSourceRepository newsSourceRepository;

    APIInterface apiInterface;
    Context context;


    public NewsSourceRepository(Context context) {
        apiInterface = APIClient.getClient().create(APIInterface.class);
        this.context = context;
    }

    public LiveData<List<Article>> getNewsSourceList() {
        getNewsSource();
        return newsSourceList;
    }

   /* private void getNewsSource() {
        Call<List<NewsSource>> call = apiInterface.getNewsSource();
        call.enqueue(new Callback<List<NewsSource>>() {
            @Override
            public void onResponse(Call<List<NewsSource>> call, Response<List<NewsSource>> response) {
                *//*newsSourceList = new MutableLiveData<List<NewsSource>>();*//*
                newsSourceList.setValue(response.body().g);
                Toast.makeText(context,"response" + response.body(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<NewsSource>> call, Throwable t) {
                Toast.makeText(context,"error - " + t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }*/

    private void getNewsSource() {
        Call<NewsSource> call = apiInterface.getNewsSource();
        call.enqueue(new Callback<NewsSource>() {
            @Override
            public void onResponse(Call<NewsSource> call, Response<NewsSource> response) {
                newsSourceList.setValue(response.body().getArticles());
            }

            @Override
            public void onFailure(Call<NewsSource> call, Throwable t) {

            }
        });
    }
}
