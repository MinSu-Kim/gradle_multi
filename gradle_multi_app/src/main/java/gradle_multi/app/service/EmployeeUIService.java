package gradle_multi.app.service;

import java.util.List;

import gradle_multi.api.daoImpl.DepartmentDaoImpl;
import gradle_multi.api.daoImpl.EmployeeDaoImpl;
import gradle_multi.api.daoImpl.TitleDaoImpl;
import gradle_multi.common.dao.DepartmentDao;
import gradle_multi.common.dao.EmployeeDao;
import gradle_multi.common.dao.TitleDao;
import gradle_multi.common.dto.Department;
import gradle_multi.common.dto.Employee;
import gradle_multi.common.dto.Title;

public class EmployeeUIService {
	private TitleDao titleDao;
	private DepartmentDao deptDao;
	private EmployeeDao empDao;

	public EmployeeUIService() {
		titleDao = new TitleDaoImpl();
		deptDao = new DepartmentDaoImpl();
		empDao = new EmployeeDaoImpl();
	}

	public List<Employee> selectEmpAll() {
		return empDao.selectEmployeeByAll();
	}

	public List<Department> selectDeptAll() {
		return deptDao.selectDepartmentByAll();
	}

	public List<Title> selectTitleAll() {
		return titleDao.selectTitleByAll();
	}

	public int updateEmpoyee(Employee item) {
		return empDao.updateEmployee(item);
	}

	public int deleteEmp(Employee item) {
		return empDao.deleteEmployee(item);
	}

	public int createItem(Employee item) {
		return empDao.insertEmployee(item);
	}
	
}
