package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dto.BoardDto;
import board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		// TODO 목록 조회 쿼리를 실행해서 실행 결과를 반환하는 기능을 구현
		return boardMapper.selectBoardList();

	}

}
