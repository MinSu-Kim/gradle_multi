package gradle_multi.app.ui;

import java.util.List;

import javax.swing.JFrame;

import gradle_multi.app.content.AbstractPanel;
import gradle_multi.app.content.PanelEmployee;
import gradle_multi.app.list.AbstractList;
import gradle_multi.app.list.EmployeeList;
import gradle_multi.app.service.EmployeeUIService;
import gradle_multi.common.dto.Employee;

@SuppressWarnings("serial")
public class EmployeeFrameUI extends AbstractFrameUI<Employee> {
	private EmployeeUIService service;
	
	public EmployeeFrameUI(String title) {
		super(title);
		setBounds(100, 100, 550, 700);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	protected void initDao() {
		service = new EmployeeUIService();		
	}

	@Override
	protected AbstractList<Employee> createListPanel() {
		return new EmployeeList();
	}

	@Override
	protected AbstractPanel<Employee> createContentPanel() {
		PanelEmployee empPanel = new PanelEmployee();
		empPanel.setDeptList(service.selectDeptAll());
		empPanel.setTitleList(service.selectTitleAll());
		return empPanel;
	}

	@Override
	protected int updateItem(Employee item) {
		return service.updateEmpoyee(item);
	}

	@Override
	protected List<Employee> getListAll() {
		return service.selectEmpAll();
	}

	@Override
	protected void clearContent() {
		pContent.clearComponent(itemList.size() == 0 ? 1 : itemList.size() + 1);
		
	}

	@Override
	protected int deleteItem(Employee item) {
		return service.deleteEmp(item);
	}

	@Override
	protected int insertItem(Employee item) {
		return service.createItem(item);
	}

}
