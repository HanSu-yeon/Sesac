package board.service;

import java.util.List;

import board.dto.BoardDto;

public interface BoardService {
	// 게시판 목록(list)을 조회해서 반환하는 메소드를 정의
	List<BoardDto> selectBoardList() throws Exception;

}
