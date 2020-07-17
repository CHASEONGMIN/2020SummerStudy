package com.hitomi.mynews;

import java.io.Serializable;

public class NewsData implements Serializable {
    private String title;
    private String urlToImage;
    private String content;

    public NewsData(){

    }

    public String getTitle() {
        return title;
    }
    public String getUrlToImage() {
        return urlToImage;
    }
    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public void setContent(String content) {
        this.content = content;
    }
}