package summer.article.service;

import java.util.List;

import summer.article.model.Article;

public interface ArticleService {
	
	int count();
	
	List<Article> findArticles(Integer currentPage, Integer perPage);
	
	int insertArticle(Article article);

	Article findByIdx(Integer idx);
}
