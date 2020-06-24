package com.tts.ttsBlog3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
  
  @GetMapping(value = "/articles/{id}")
  public String showById(@PathVariable Long id, Article article, Model model) {
    Article articleFound = articleRepository.findArticleById(id);
    model.addAttribute("title", articleFound.getTitle());
    model.addAttribute("author", articleFound.getAuthor());
    model.addAttribute("entry", articleFound.getEntry());
    model.addAttribute("createdAt", articleFound.getCreatedAt());
    return "article/show";
  }
  
  @GetMapping(value = "/articles/new")
  public String getNewArticleForm(Model model) {
    model.addAttribute("article", new Article());
    return "article/new";
  }

  @PostMapping(value = "/articles")
  public String createNewArticle(Article article, Model model) {
    Article articleToAdd = new Article(article.getTitle(),
        article.getAuthor(), article.getEntry(), article.getCreatedAt());
    articleRepository.save(articleToAdd);
    model.addAttribute("title", articleToAdd.getTitle());
    model.addAttribute("author", articleToAdd.getAuthor());
    model.addAttribute("entry", articleToAdd.getEntry());
    model.addAttribute("createdAt", articleToAdd.getCreatedAt());
    return "article/show";
  }

}

//@Controller
//public class MainController {
//
//  @Autowired
//  private ArticleRepository articleRepository;
//
// 1st
//  @GetMapping(value = { "/", "/articles" })
//  public String index(Article article, Model model) {
//    List<Article> articles = articleRepository.findAll();
//    model.addAttribute("articles", articles);
//    return "article/index";
//  }
//
// 4th
//  @PostMapping(value = "/articles/new")
//  public String create(Article article, Model model) {
//    articleRepository.save(article);
//    model.addAttribute("title", article.getTitle());
//    model.addAttribute("author", article.getAuthor());
//    model.addAttribute("entry", article.getEntry());
//    return "article/show";
//  }
//
// 3rd
//  @GetMapping(value = "/articles/new")
//  public String newArticle(Model model) {
//    model.addAttribute("article", new Article());
//    return "article/new";
//  }
//
// 2nd
//  @GetMapping("/articles/{articleId}")
//  public String getArticleById(
//      @PathVariable("articleId") Long articleId,
//      Model model) {
//    Optional<Article> article = articleRepository
//        .findById(articleId);
////    System.out.println(article);
//    model.addAttribute("article", article.get());
//    return "article/show";
//  }
//
// 5th
//  @GetMapping(value = "/articles/{articleId}/edit")
//  public String goToArticleEdit(
//      @PathVariable("articleId") Long articleId,
//      Model model) {
//    Optional<Article> editArticle = articleRepository
//        .findById(articleId);
//    model.addAttribute("article", editArticle.get());
//    return "article/edit";
//  }
//
// 6th
//  @RequestMapping(value = "/articles/{articleId}/edit", method = RequestMethod.POST)
//  public String updateArticle(
//      @PathVariable("articleId") Long articleId,
//      Article article, Model model) {
//    Optional<Article> optionArticle = articleRepository
//        .findById(articleId);
//    Article updateArticle = optionArticle.get();
//    updateArticle.setTitle(article.getTitle());
//    updateArticle.setAuthor(article.getAuthor());
//    updateArticle.setEntry(article.getEntry());
//    articleRepository.save(updateArticle);
//    model.addAttribute("article", updateArticle);
//    return "article/show";
//  }
//
// 7th
//  @RequestMapping(value = "/articles/{articleId}/delete", method = RequestMethod.GET)
//  public String deleteArticleWithId(
//      @PathVariable("articleId") Long articleId,
//      Article article) {
//    Optional<Article> optionArticle = articleRepository.findById(articleId);
//    Article garbageArticle = optionArticle.get();
//    articleRepository.delete(garbageArticle);;
//    return "redirect:/articles";
//  }
//
//}
//
