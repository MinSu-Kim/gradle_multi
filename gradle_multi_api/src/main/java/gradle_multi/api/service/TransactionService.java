package gradle_multi.api.service;

import org.apache.ibatis.session.SqlSession;

import gradle_multi.api.jdbc.MyBatisSqlSessionFactory;
import gradle_multi.common.dto.Department;
import gradle_multi.common.dto.Title;

public class TransactionService {
	private static final String DEPT_NS = "gradle_multi.api.dao.DepartmentDao";
	private static final String TITLE_NS = "gradle_multi.api.dao.TitleDao";

	public void addTitleDeparment(Title title, Department department) {
		int res = 0;
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			res += sqlSession.insert(DEPT_NS + ".insertDepartment", department);
			res += sqlSession.insert(TITLE_NS + ".insertTitle", title);
			if (res == 2)
				sqlSession.commit();
			else
				throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			throw new RuntimeException(e.getCause());
		} finally {
			sqlSession.close();
		}
	}

	public int removeTitleDeparment(Title title, Department department) {
		int res = 0;
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			res += sqlSession.delete(DEPT_NS + ".deleteDepartment", department);
			res += sqlSession.delete(TITLE_NS + ".deleteTitle", title);
			if (res == 2)
				sqlSession.commit();
			else
				throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			throw new RuntimeException(e.getCause());
		} finally {
			sqlSession.close();
		}
		return res;
	}

}
