package com.example.rohit.mvvm_rest_api_demojava.views.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.rohit.mvvm_rest_api_demojava.views.models.Article;
import com.example.rohit.mvvm_rest_api_demojava.views.repository.NewsSourceRepository;

import java.util.List;

public class NewsSourceViewModel extends AndroidViewModel {

    NewsSourceRepository newsSourceRepository;
    LiveData<List<Article>> newsSource;
    private boolean loadData = false;

    public NewsSourceViewModel(@NonNull Application application) {
        super(application);
        newsSourceRepository = new NewsSourceRepository(application);
        //newsSource = newsSourceRepository.getNewsSourceList();
    }



    public LiveData<List<Article>> getNewsSource() {
       return newsSourceRepository.getNewsSourceList();
    }

   /* public LiveData<List<NewsSource>> getNewsSource() {
        return newsSource;
    }*/

    public boolean isLoadData() {
        return loadData;
    }

    public void setLoadData(boolean loadData) {
        this.loadData = loadData;
    }
}
