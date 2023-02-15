package com.java.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FController {
	
	@GetMapping("index")	//url에 http://localhost:8181/index 라고 들어오면 @Controller있는데로 와서 index 찾아서 여기로 보내줘
	public String index() {
		return "index";
	}//index()

	@GetMapping("aaa")
	public String aaa() {
		return "aaa";
	}
}
