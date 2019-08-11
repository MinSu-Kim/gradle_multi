package gradle_multi.api.dao;

import java.util.List;

import gradle_multi.common.dto.Board;
import gradle_multi.common.dto.Criteria;

public interface BoardDao {
	List<Board> getList();
	
	List<Board> getListCriteria(Criteria cri) ;
	int countPaging();
	
	int insertBoard(Board board);
	Board readBoard(long bno);
	int deleteBoard(long bno);
	int updateBoard(Board board);

	int getNextBno();
}
