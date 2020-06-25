package com.tts.ttsBlog3.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tts.ttsBlog3.model.Article;
import com.tts.ttsBlog3.repository.ArticleRepository;

@Controller
public class ArticleController {

  @Autowired
  private ArticleRepository articleRepository;

  @GetMapping(value = {"/", "/articles"})
  public String index(Article article, Model model) {
    Iterable<Article> articles = articleRepository.findAll();
    model.addAttribute("articles", articles);
    return "article/index";
  }
  
  @GetMapping(value = "/articles/{articleId}")
  public String showById(@PathVariable("articleId") Long articleId, Model model) {
    Optional<Article> optionArticle = articleRepository.findById(articleId);
    Article articleFound = optionArticle.get();
    model.addAttribute("article", articleFound);
    return "article/show";
  }
  
  @GetMapping(value = "/articles/new")
  public String getNewArticleForm(Model model) {
    model.addAttribute("article", new Article());
    return "article/new";
  }

  @PostMapping(value = "/articles/new")
  public String createNewArticle(Article article, Model model) {
    articleRepository.save(article);
    model.addAttribute("article", article);
    return "article/show";
  }
  
  @GetMapping(value = "/articles/{articleId}/edit")
  public String getEditForm(@PathVariable("articleId") Long articleId, Model model) {
    Optional<Article> optionArticle = articleRepository.findById(articleId);
    Article articleFound = optionArticle.get();
    model.addAttribute("article", articleFound);
    return "article/edit";
  }
  
  @PostMapping(value = "/articles/{articleId}/edit")
  public String updateArticle(@PathVariable("articleId") Long articleId,
      Article article, Model model) {
    Optional<Article> optionArticle = articleRepository.findById(articleId);
    Article updateArticle = optionArticle.get();
    updateArticle.setTitle(article.getTitle());
    updateArticle.setAuthor(article.getAuthor());
    updateArticle.setEntry(article.getEntry());
    articleRepository.save(updateArticle);
    model.addAttribute("article", updateArticle);
    return "article/show";
}
  
  @RequestMapping(value = "/articles/{articleId}/delete", method = RequestMethod.GET)
  public String deleteArticle(@PathVariable("articleId") Long articleId) {
    articleRepository.deleteById(articleId);
    return "redirect:/articles";
  }

}
