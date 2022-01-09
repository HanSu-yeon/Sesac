package board.service;

import java.util.List;

import board.dto.BoardDto;

public interface BoardService {
	// �Խ��� ���(list)�� ��ȸ�ؼ� ��ȯ�ϴ� �޼ҵ带 ����
	List<BoardDto> selectBoardList() throws Exception;

	void insertBoard(BoardDto board) throws Exception;

	BoardDto selectBoardDetail(int boardIdx) throws Exception;
}
