package summer.user.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import summer.user.model.User;

@Repository
public class UserRepository {

	@Autowired private SqlSession sqlSession;
	
	public int create(User user) {
		return sqlSession.insert("user.create",user);
	}
	
	public User findByUserName(String username) {
		return sqlSession.selectOne("user.findByUserName", username);
	}

}
