package gradle_multi.common.dao;

import java.util.List;

import gradle_multi.common.dto.Department;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();
	int insertDepartment(Department title);
	int deleteDepartment(Department title);
	int updateDepartment(Department title);
	Department selectDepartmentByCode(Department title);
}
