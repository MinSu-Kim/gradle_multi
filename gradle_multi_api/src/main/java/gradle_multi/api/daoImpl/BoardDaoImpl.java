package gradle_multi.api.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import gradle_multi.api.jdbc.MyBatisSqlSessionFactory;
import gradle_multi.common.dao.BoardDao;
import gradle_multi.common.dto.Board;
import gradle_multi.common.dto.Criteria;

public class BoardDaoImpl implements BoardDao {
	private static final String namespace = "mappers.BoardMapper";

	@Override
	public List<Board> getList() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".getList");
		}
	}

	@Override
	public int insertBoard(Board board) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertBoard", board);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public Board readBoard(long bno) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".readBoard", bno);
		}
	}

	@Override
	public int deleteBoard(long bno) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.delete(namespace + ".deleteBoard", bno);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateBoard(Board board) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.update(namespace + ".updateBoard", board);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public List<Board> getListCriteria(Criteria cri) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".getListCriteria", cri);
		}
	}

	@Override
	public int countPaging() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".countPaging");
		}
	}

	@Override
	public int getNextBno() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".getNextBno");
		}
	}


}
