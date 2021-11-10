package com.example.newsapi.payload.response;

import com.example.newsapi.model.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsArticleResponse {
    private String status;
    private Integer totalResults;
    private List<Article> articles;
}
