package com.example.rohit.mvvm_rest_api_demojava.views.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.rohit.mvvm_rest_api_demojava.R;
import com.example.rohit.mvvm_rest_api_demojava.views.models.Article;
import com.example.rohit.mvvm_rest_api_demojava.views.models.NewsSource;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ROHIT on 5/17/2018.
 */

public class RecyclerNewsSource extends RecyclerView.Adapter<RecyclerNewsSource.RecyclerSource> {

    private Context mContext;

    private List<Article> mNewsSources = new ArrayList<>();

    public RecyclerNewsSource(Context context, List<Article> newsSource) {
        this.mContext = context;
        this.mNewsSources = newsSource;
    }

    /**
     * Used for creating the view
     * we can also return different view types by using parameter viewType
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public RecyclerSource onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_news_sorce,parent,false);

        RecyclerSource recyclerSource = new RecyclerSource(view);

        return recyclerSource;
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerSource holder, int position) {

        Glide.with(mContext).load(mNewsSources.get(position).getUrlToImage()).
                into(holder.sourceImagee);
        holder.sourceName.setText("Source name - " + mNewsSources.get(position).getTitle());

        Toast.makeText(mContext,"" + mNewsSources.get(position).getTitle(),Toast.LENGTH_LONG).show();
    }

    /**
     * Returns total size of items in recyclerview
     * @return
     */
    @Override
    public int getItemCount() {
        return mNewsSources.size();
    }

    class RecyclerSource extends RecyclerView.ViewHolder {

        ImageView sourceImagee;
        TextView sourceName;
        LinearLayout source;

        public RecyclerSource(View itemView) {
            super(itemView);

            sourceImagee = (ImageView)itemView.findViewById(R.id.imageView_source_image);
            sourceName = (TextView)itemView.findViewById(R.id.textView_source_name);

            source = (LinearLayout)itemView.findViewById(R.id.linearLayout_source);
        }
    }

    public void setData(List<Article> list) {
        this.mNewsSources = list;
        notifyDataSetChanged();
    }
}
