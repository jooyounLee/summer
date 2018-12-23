package summer.article.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import summer.article.model.Article;

@Repository
public class ArticleRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public int count() {
		return sqlSession.selectOne("article.count");
	}
	
	public List<Article> findArticles() {
		return sqlSession.selectList("article.articles");
	}
	
	public int insertArticle(Article article) {
		return sqlSession.insert("article", article);
	}
}
