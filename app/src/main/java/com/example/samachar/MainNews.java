package com.example.samachar;

import java.util.ArrayList;

public class MainNews {
    private String status;
    private String totalResults;
    private ArrayList<HelperClass> articles;

    public MainNews(String status, String totalResults, ArrayList<HelperClass> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<HelperClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<HelperClass> articles) {
        this.articles = articles;
    }
}
