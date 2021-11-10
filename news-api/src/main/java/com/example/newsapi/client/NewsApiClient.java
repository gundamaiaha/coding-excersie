package com.example.newsapi.client;

import com.example.newsapi.constants.APIURL;
import com.example.newsapi.payload.response.NewsArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class NewsApiClient {


    private final RestTemplate restTemplate;



    public NewsArticleResponse getNewsArticleResponse(){
        final ResponseEntity<NewsArticleResponse> newsArticlesResponse = restTemplate.exchange(APIURL.GET_ARTICLES, HttpMethod.GET, null,
                NewsArticleResponse.class
        );

        return newsArticlesResponse.getBody();
    }



}
