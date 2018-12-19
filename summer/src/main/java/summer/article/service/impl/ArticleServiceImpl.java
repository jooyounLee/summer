package summer.article.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import summer.article.model.Article;
import summer.article.repository.ArticleRepository;
import summer.article.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public int count() {
		return articleRepository.count();
	}
	
	@Override
	public List<Article> findArticles() {
		return articleRepository.findArticles();
	}
}
