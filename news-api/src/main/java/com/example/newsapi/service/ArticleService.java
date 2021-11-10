package com.example.newsapi.service;

import com.example.newsapi.model.Article;

import java.util.List;

public interface ArticleService {

     List<Article> getAllArticles();

    List<String> getAllAuthors();

    List<Article> getArticlesByAuthor(String author);
}
