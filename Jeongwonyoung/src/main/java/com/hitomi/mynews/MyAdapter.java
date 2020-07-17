package com.hitomi.mynews;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<NewsData> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView TextView_title;
        public TextView TextView_content;
        public ImageView ImageView_news;

        public MyViewHolder(View v) {
            super(v);
            TextView_title = v.findViewById(R.id.TextView_title);
            TextView_content = v.findViewById(R.id.TextView_content);
            ImageView_news = v.findViewById(R.id.ImageView_news);
        }
    }

    public MyAdapter(List<NewsData> myDataset, Context context) {
        mDataset = myDataset;
        Fresco.initialize(context);
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        androidx.constraintlayout.widget.ConstraintLayout v
                =(androidx.constraintlayout.widget.ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_news, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        NewsData news = mDataset.get(position);

        holder.TextView_title.setText(news.getTitle());
        holder.TextView_content.setText(news.getContent());

        Uri uri = Uri.parse(news.getUrlToImage());
        holder.ImageView_news.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
