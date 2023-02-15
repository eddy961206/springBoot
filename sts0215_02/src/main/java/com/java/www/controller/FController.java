package com.java.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FController {

	@GetMapping("/login")
	public String login(Model model) { 	//model이 request와 같다고 생각하면.
		return "login";
	}
	@GetMapping("/event")
	public String event(Model model) { 	//model이 request와 같다고 생각하면.
		return "event";
	}
}
