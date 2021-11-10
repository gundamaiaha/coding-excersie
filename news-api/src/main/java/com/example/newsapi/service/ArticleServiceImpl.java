package com.example.newsapi.service;

import com.example.newsapi.client.NewsApiClient;
import com.example.newsapi.constants.APIURL;
import com.example.newsapi.model.Article;
import com.example.newsapi.payload.response.NewsArticleResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {

    private final NewsApiClient newsApiClient;

    @Override
    public List<Article> getAllArticles() {
        NewsArticleResponse newsArticleResponse = newsApiClient.getNewsArticleResponse();
        return newsArticleResponse.getArticles();
    }

    @Override
    public List<String> getAllAuthors(){
        final NewsArticleResponse newsArticleResponse = newsApiClient.getNewsArticleResponse();
        return newsArticleResponse.getArticles().stream()
                .filter(article -> StringUtils.isNotBlank(article.getAuthor()))
                .map(Article::getAuthor)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

    }


    @Override
    public List<Article> getArticlesByAuthor(final String author){
     List<Article> articles = getAllArticles();

        List<Article> articlesByAuthor = articles.stream()
                .filter(article -> author.equalsIgnoreCase(article.getAuthor()))
                .collect(Collectors.toList());
        return articlesByAuthor;


    }











}
