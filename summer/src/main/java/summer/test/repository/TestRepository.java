package summer.test.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {

	@Autowired private SqlSession sqlSession;
	
	public int count() {
		return sqlSession.selectOne("test.test");
	}
}
