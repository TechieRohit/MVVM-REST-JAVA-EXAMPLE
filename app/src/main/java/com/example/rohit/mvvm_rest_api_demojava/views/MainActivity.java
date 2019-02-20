package com.example.rohit.mvvm_rest_api_demojava.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rohit.mvvm_rest_api_demojava.R;
import com.example.rohit.mvvm_rest_api_demojava.views.adapters.RecyclerNewsSource;
import com.example.rohit.mvvm_rest_api_demojava.views.models.Article;
import com.example.rohit.mvvm_rest_api_demojava.views.retrofit.APIClient;
import com.example.rohit.mvvm_rest_api_demojava.views.retrofit.APIInterface;
import com.example.rohit.mvvm_rest_api_demojava.views.viewmodels.NewsSourceViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerNewsSource recyclerNewsSource;
    ArrayList<Article> newsSources = new ArrayList<>();

    NewsSourceViewModel newsSourceViewModel;
    APIInterface apiInterface;
    Button loadData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        loadData = findViewById(R.id.load_data);

        newsSourceViewModel = ViewModelProviders.of(this).get(NewsSourceViewModel.class);
        //apiInterface = APIClient.getClient().create(APIInterface.class);

        onClick();
        observer();
    }

    private void onClick() {
        loadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newsSourceViewModel.getNewsSource();
                Toast.makeText(MainActivity.this,"clicked",Toast.LENGTH_LONG).show();
            }
        });

    }

    private void observer() {

        newsSourceViewModel.getNewsSource().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(@Nullable List<Article> newsSources) {
                Toast.makeText(MainActivity.this,"callback",Toast.LENGTH_LONG).show();
                recyclerNewsSource.setData(newsSources);
            }
        });


    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerNewsSource = new RecyclerNewsSource(this,newsSources);
        recyclerView.setAdapter(recyclerNewsSource);
    }
}
