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
	// ModelAndView=> 비즈니스 로직을 처리하고 처리된 결과를 지정된 view를 통해 내려보내주겠다
	public ModelAndView openBoardList() throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardList");
		// TODO. 비즈니스 로직을 호출, 실행 => 서비스
		List<BoardDto> data = boardService.selectBoardList();
		mv.addObject("list", data);
		return mv;
	}
}
