package summer.article.repository;

import java.util.List;
import java.util.Map;

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
	
	public List<Article> findArticles(Map<String,Object> pageInfo) {
		return sqlSession.selectList("article.articles", pageInfo);
	}
	
	public int insertArticle(Article article) {
		return sqlSession.insert("article", article);
	}
}
