package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.dto.BoardDto;
import board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	@RequestMapping("/board/openBoardList.do")
	// ModelAndView=> ����Ͻ� ������ ó���ϰ� ó���� ����� ������ view�� ���� ���������ְڴ�
	public ModelAndView openBoardList() throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardList");
		// TODO. ����Ͻ� ������ ȣ��, ���� => ����
		List<BoardDto> data = boardService.selectBoardList();
		mv.addObject("resultList", data);
		return mv;
	}

	// �Խñ� ��� �������� ���� ��û�� ó���ϴ� ��Ʈ�ѷ�
	@RequestMapping("/board/openBoardWrite.do")
	public String openBoardWrite() throws Exception {
		return "/board/boardWrite"; // ��� ȭ�� �������� ��ȯ
	}

	// �Է��� �Խù��� ����(���) ��û�� ó���ϴ� ��Ʈ�ѷ�
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(BoardDto board) throws Exception {
		boardService.insertBoard(board);
		return "redirect:/board/openBoardList.do"; // ��Ͽ� �����ϸ� ��� �������� �����̷���
	}

	@RequestMapping("/board/openBoardDetail.do")
	public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardDetail");

		BoardDto data = boardService.selectBoardDetail(boardIdx);
		mv.addObject("resultDetail", data);
		return mv;

	}
}
