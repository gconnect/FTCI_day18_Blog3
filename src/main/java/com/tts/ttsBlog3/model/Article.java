package com.tts.ttsBlog3.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "article_id")
    private Long id;
    
    private String title;
    private String author;
    private String entry;
    
    @CreationTimestamp
    private Date createdAt;
    
    @UpdateTimestamp
    private Date updatedAt;

    public Article() {}

    public Article(String title, String author,
        String entry, Date createdAt) {
      this.title = title;
      this.author = author;
      this.entry = entry;
      this.createdAt = createdAt;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public String getAuthor() {
      return author;
    }

    public void setAuthor(String author) {
      this.author = author;
    }

    public String getEntry() {
      return entry;
    }

    public void setEntry(String entry) {
      this.entry = entry;
    }

    public Date getCreatedAt() {
      return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
      this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
      return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
      this.updatedAt = updatedAt;
    }

    public Long getArticleId() {
      return id;
    }

    @Override
    public String toString() {
      return "Article [articleId=" + id + ", title=" + title
          + ", author=" + author + ", entry=" + entry
          + ", createdAt=" + createdAt + ", updatedAt="
          + updatedAt + "]";
    }

    
}

