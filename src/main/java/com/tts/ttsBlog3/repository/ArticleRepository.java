package com.tts.ttsBlog3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tts.ttsBlog3.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
  public Optional<Article> findById(Long articleId);
}
