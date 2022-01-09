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
	// ModelAndView=> 비즈니스 로직을 처리하고 처리된 결과를 지정된 view를 통해 내려보내주겠다
	public ModelAndView openBoardList() throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardList");
		// TODO. 비즈니스 로직을 호출, 실행 => 서비스
		List<BoardDto> data = boardService.selectBoardList();
		mv.addObject("resultList", data);
		return mv;
	}

	// 게시글 등록 페이지에 대한 요청을 처리하는 컨트롤러
	@RequestMapping("/board/openBoardWrite.do")
	public String openBoardWrite() throws Exception {
		return "/board/boardWrite"; // 등록 화면 페이지를 반환
	}

	// 입력한 게시물을 저장(등록) 요청을 처리하는 컨트롤러
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(BoardDto board) throws Exception {
		boardService.insertBoard(board);
		return "redirect:/board/openBoardList.do"; // 등록에 성공하면 목록 페이지로 리다이렉션
	}

	@RequestMapping("/board/openBoardDetail.do")
	public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardDetail");

		BoardDto data = boardService.selectBoardDetail(boardIdx);
		mv.addObject("resultDetail", data);
		return mv;

	}
}
