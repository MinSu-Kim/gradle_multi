package gradle_multi.app.list;

import javax.swing.SwingConstants;

import gradle_multi.common.dto.Board;

@SuppressWarnings("serial")
public class BoardList extends AbstractList<Board> {
	
	public BoardList() {
		super("게시판");
	}
	
	@Override
	protected void tableAlignmentAndWidth() {
		// 직책번호, 직책명은 가운데 정렬  bno, title, content, writer, regdate, updatedate
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4);
		// 직책번호, 직책명의 폭을 (100, 200)으로 가능하면 설정
		tableSetWidth(100, 150, 100, 100, 100);
	}

	@Override
	protected Object[] toArray(int idx) {
		Board board = itemList.get(idx);
		return board.toArray();
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "번호", "제목", "작성자", "작성일", "수정일"};
	}

}
