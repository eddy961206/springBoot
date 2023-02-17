package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.vo.Board;

@Controller
@RequestMapping("/board") // /슬래시 기본은 앞에다 넣는건데 생략해도. 오류 걸리면 넣거나 뺴거나 해봐. 뒤에 붙여도 되긴 됨
public class BoardController {

	@GetMapping("/fboardWrite")
	public String fboardWrite() {
		return "board/fboardWrite";
	}
	
	@PostMapping("/fboardView")
	public String boardView(Board board, Model model) {
		
		model.addAttribute(board);
		
		return "board/fboardView";
	}
	
	
	
}
