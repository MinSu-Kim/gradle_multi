package gradle_multi.api.dao;

import java.util.List;
import java.util.Map;

import gradle_multi.common.dto.Employee;
import gradle_multi.common.dto.State;

public interface EmployeeDao {
	List<Employee> selectEmployeeByAll();
	int insertEmployee(Employee employee);
	int deleteEmployee(Employee employee);
	int updateEmployee(Employee employee);
	Employee selectEmployeeByCode(Employee employee);
	
	Map<String, Object> getSalaryByDepartment(Map<String, Object> param);
	State getStateSalaryByDepartment(Map<String, Object> param);
}
