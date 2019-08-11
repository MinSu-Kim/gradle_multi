package gradle_multi.api.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import gradle_multi.api.dao.PostDao;
import gradle_multi.api.jdbc.MyBatisSqlSessionFactory;
import gradle_multi.common.dto.Criteria;
import gradle_multi.common.dto.Post;

public class PostDaoImpl implements PostDao {
	private static final String namespace = "gradle_multi.api.dao.PostDao";

	@Override
	public List<Post> selectPostByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectPostByAll");
		}
	}

	@Override
	public List<Post> listCriteria(Criteria cri){
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".listCriteria", cri);
		}
	}

	@Override
	public int countPaging() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".countPaging");
		}
	}

}
