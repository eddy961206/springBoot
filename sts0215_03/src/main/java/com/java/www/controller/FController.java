package com.java.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FController {
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("event")
	public String event() {
		return "event";
	}

}
