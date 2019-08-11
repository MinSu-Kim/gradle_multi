package gradle_multi.app.ui;

import java.util.List;

import gradle_multi.api.daoImpl.TitleDaoImpl;
import gradle_multi.app.content.AbstractPanel;
import gradle_multi.app.content.PanelTitle;
import gradle_multi.app.list.AbstractList;
import gradle_multi.app.list.TitleList;
import gradle_multi.common.dao.TitleDao;
import gradle_multi.common.dto.Title;

@SuppressWarnings("serial")
public class TitleFrameUI extends AbstractFrameUI<Title> {
	private TitleDao dao;
	
	public TitleFrameUI(String title) {
		super(title);
	}
	
	@Override
	protected  void initDao() {
		dao = new TitleDaoImpl();
	}
	
	@Override
	protected AbstractList<Title> createListPanel(){
		return new TitleList();
	}
	
	@Override
	protected AbstractPanel<Title> createContentPanel(){
		return new PanelTitle("직책 정보");
	}

	@Override
	protected void clearContent() {
		pContent.clearComponent(itemList.size() == 0 ? 1 : itemList.size() + 1);
	}
	
	@Override
	public List<Title> getListAll(){
		return dao.selectTitleByAll();
	}
	
	@Override
	protected int updateItem(Title item) {
		return dao.updateTitle(item);
	}

	@Override
	protected int insertItem(Title item) {
		return dao.insertTitle(item);
	}
	
	@Override
	protected int deleteItem(Title item) {
		return dao.deleteTitle(item);
	}
}
