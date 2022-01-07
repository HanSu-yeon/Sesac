package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
		mv.addObject("list", data);
		return mv;
	}
}
