package gradle_multi.api.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import gradle_multi.api.dao.DepartmentDao;
import gradle_multi.api.jdbc.MyBatisSqlSessionFactory;
import gradle_multi.common.dto.Department;

public class DepartmentDaoImpl implements DepartmentDao {
//	private static final String namespace = "mappers.DepartmentMapper";
	private static final String namespace = "gradle_multi.api.dao.DepartmentDao";

	@Override
	public List<Department> selectDepartmentByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectDepartmentByAll");
		}
	}

	@Override
	public int insertDepartment(Department department) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertDepartment", department);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteDepartment(Department department) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.delete(namespace + ".deleteDepartment", department);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateDepartment(Department department) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.update(namespace + ".updateDepartment", department);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public Department selectDepartmentByCode(Department department) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectDepartmentByCode", department);
		}
	}

}
