package com.hitomi.mynews;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView; 

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mRecyclerView =  findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        queue = Volley.newRequestQueue(this);
        getNews();
}

    public void getNews() {

        String url = "http://newsapi.org/v2/top-headlines?country=kr&apiKey=d601cf623e47481d890990d9e5c350b0";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("NEWS", response);

                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            JSONArray arrayArticles = jsonObj.getJSONArray("articles");

                            List<NewsData> news = new ArrayList<>();

                            for (int i = 0, j = arrayArticles.length(); i < j; i++) {
                                JSONObject obj = arrayArticles.getJSONObject(i);

                                Log.d("NEWS", obj.toString());

                                NewsData newsData = new NewsData();
                                newsData.setTitle(obj.getString("title"));
                                newsData.setUrlToImage(obj.getString("urlToImage"));
                                newsData.setContent(obj.getString("content"));

                                news.add(newsData);
                            }

                            mAdapter = new MyAdapter(news, NewsActivity.this);
                            mRecyclerView.setAdapter(mAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) { 

            }
        });

        queue.add(stringRequest);
    }
    }


