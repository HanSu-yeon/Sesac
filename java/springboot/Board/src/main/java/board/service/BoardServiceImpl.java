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
		// TODO ��� ��ȸ ������ �����ؼ� ���� ����� ��ȯ�ϴ� ����� ����
		return boardMapper.selectBoardList();

	}

	@Override
	public void insertBoard(BoardDto board) throws Exception {
		boardMapper.insertBoard(board);
	}

	@Override
	public BoardDto selectBoardDetail(int boardIdx) throws Exception {
		boardMapper.updateHitCount(boardIdx);
		return boardMapper.selectBoardDetail(boardIdx);
	}

}