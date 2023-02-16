package com.java.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.service.MService;

@Controller
//@RequestMapping("event") // @GetMapping("comm/index") 'comm/' 얘가 index 앞에 붙는 격
public class FController {
	
	@Autowired
	MService mservice;
	
	@Autowired
	HttpSession session;

	@GetMapping("/")	//index라고 치고 들어오면 에러뜨게함. 그냥 localhost:8080만 치고 들어오게 해야.
	public String index2(Model model) {
		String name = "홍길동";
		model.addAttribute("fname",name); // model은 dispatcher.forward 안해도 한 페이지 이동은 가능. 그 이상안돼 
		System.out.println("controller name : " + name);
		return "index";
	}
	
	@GetMapping("login")
	public String login(Model model) {
		String id = mservice.memberSelectOne();
		System.out.println("controller id : " + id);
		session.setAttribute("sessionId", id);
		return "event/login";
	}
	
	@GetMapping("logout")	
	public String logout(Model model) {
		session.invalidate();
		return "event/logout";	// 뷰페이지는 event/logout으로 해야.
	}
	
	@GetMapping("event")	// RequestMapping : get,post 둘 다 받아짐. 웬만하면 이렇게 해
	public ModelAndView event() {
		ModelAndView mv = new ModelAndView();	// 이거 안쓰면 event() 매개변수 안에 Model model넣어야. 나중에 매개변수 많아질 것.
		String name = "이순신";
		mv.addObject("fname", name);
		mv.setViewName("event/event"); // view페이지 
		return mv;
	}
	
	@PostMapping("event")
	public String doEvent(Model model) {
		return "event/doEvent";
	}
	

}//class
