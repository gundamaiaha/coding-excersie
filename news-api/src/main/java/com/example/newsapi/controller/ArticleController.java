package com.example.newsapi.controller;

import com.example.newsapi.model.Article;
import com.example.newsapi.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/newsapi/v1/news")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/articles")
    public List<Article> getAllArticles(){
       return articleService.getAllArticles();
    }

    @GetMapping("/articles/authors")
    public List<String> getAllAuthors(){
        return articleService.getAllAuthors();
    }


//api/v1/news/articles/author/{mane}

    @GetMapping("/articles/author/{author}")
    public ResponseEntity<?> getArticlesByAuthor(@PathVariable String author){
          if(StringUtils.isBlank(author)){
              return ResponseEntity.badRequest().body("Author is invalid");
          }

        List<Article> articlesByAuthor = articleService.getArticlesByAuthor(author);

          if(CollectionUtils.isEmpty(articlesByAuthor)){
              return  new ResponseEntity<>("no articles found for the author :"+author,
                      HttpStatus.NOT_FOUND);
          }

          return ResponseEntity.ok(articlesByAuthor);

    }




}
