package gradle_multi.common.dao;

import java.util.List;

import gradle_multi.common.dto.Title;

public interface TitleDao {
	List<Title> selectTitleByAll();
	int insertTitle(Title title);
	int deleteTitle(Title title);
	int updateTitle(Title title);
	Title selectTitleByCode(Title title);
}
