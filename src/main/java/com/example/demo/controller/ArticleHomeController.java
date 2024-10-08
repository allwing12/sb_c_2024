package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.VO.Article;

@Controller
public class ArticleHomeController {
	private int articlesLastId;
	private List<Article> articles;
	
	public ArticleHomeController () {
		articlesLastId = 0;
		articles = new ArrayList<>();
	}
	
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd (String title, String body) {
		int id = articlesLastId + 1;
		Article article = new Article (id,title,body);
		
		articles.add(article);
		articlesLastId = id;
		
		return article;
	}
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articles;
	}
}
