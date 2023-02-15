package com.java.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.service.MService;

@Controller
public class FController {
	
	@Autowired
	MService mservice;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("login")
	public String login(Model model) {
		mservice.selectOne();
		return "login";
	}
	
	@GetMapping("event")
	public String event(Model model) {
		mservice.eventSelectOne();
		return "login";
	}

}
