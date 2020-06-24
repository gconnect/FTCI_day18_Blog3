package com.tts.ttsBlog3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.ttsBlog3.model.Article;

@Repository
public interface ArticleRepository
    extends CrudRepository<Article, Long> {
  public Article findArticleById(Long article_id);
}
