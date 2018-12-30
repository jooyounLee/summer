package summer.article.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<Article> findArticles(Integer currentPage, Integer perPage) {
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		
		if(currentPage == null || currentPage < 0) {
			currentPage = 1;
		}
		if(perPage == null || perPage < 0) {
			perPage = 5;
		}
		   
		int startPost = (currentPage - 1) * perPage;
		
		pageInfo.put("offset", startPost);
		pageInfo.put("perPage", perPage);
		
		return articleRepository.findArticles(pageInfo);
	}

	@Override
	public int insertArticle(Article article) {
		return articleRepository.insertArticle(article);
	}
	
}
