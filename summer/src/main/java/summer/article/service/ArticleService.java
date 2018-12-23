package summer.article.service;

import java.util.List;

import summer.article.model.Article;

public interface ArticleService {
	
	int count();
	
	List<Article> findArticles();
	
	int insertArticle(Article article);
}
