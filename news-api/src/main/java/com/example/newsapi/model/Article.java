package com.example.newsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Comparable<Article>{

  private Source source;
  private String author;
  private String title;
  private String description;
  private String url;
  private String urlToImage;
  private String publishedAt;
  private String content;


  @Override
  public int compareTo(Article o) {
    return this.getAuthor().compareTo(o.getAuthor());
  }
}
