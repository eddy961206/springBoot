package com.java.controller;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.vo.Member;

@Controller
@RequestMapping("/member")
public class MController {

	@ResponseBody	// 얘가 있어야 .jsp로 인식 안 함!!!!
	@PostMapping("/checkId")
//	public Member checkId(Member m) { 	// 객체로 받는 것의 장점이 null받아도 상관없음. 1개만 받아야 하는 경우라도 객체로 받는게 편해.
	public String checkId(@RequestBody Member m) { 	// json 타입으로 받아올 때 @RequestBody가 있어야. @RequsetBody자체가 JSON타입의 것을 받을 때 사용.
		System.out.println("MController id : " + m.getId());
		// 객체로 데이터 전송
		String[] hobbys = {"swim", "game", "book"};  
		Member member = new Member("aaa", "1111", "홍길동", "010-1111-1111", "male", hobbys); 
		
		// JSON으로 데이터 전송
		JSONObject obj1 = new JSONObject();  // {}
		obj1.put("name", "kim");
		obj1.put("age", 19);	//{"name":"kim","age":19,..}
		obj1.put("address", null);
		obj1.put("isMarried", false);
		
		JSONObject obj2 = new JSONObject(); // {}
		obj2.put("name", "lee");
		obj2.put("age", 22);	//{"name":"lee","age":22,..}
		obj2.put("address", "seoul");
		obj2.put("isMarried", true);
		
		JSONArray arr = new JSONArray();	// [] 
		arr.add(obj1);	// [{}]
		arr.add(obj2);	// [{},{}]
		System.out.println(obj1.toJSONString());
		System.out.println(obj2.toJSONString());
		System.out.println(arr.toJSONString());
		
		
		// 공공데이터 가져오기
		PublicData publicData = new PublicData();
		System.out.println("공공데이터 : ");
		try {
			publicData.publicData();	//return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arr.toJSONString(); 		
	}
	
	@GetMapping("/memberWrite")	// 회원가입
	public String memberWrite() {
		return "member/memberWrite";
	}
	
	@PostMapping("/memberView")
	public String memberView(Member member, Model model) {	
		
		model.addAttribute("member", member); 		// 객체로 넘김
		
		return "member/memberView";
		
	} // memberView - 객체사용
	
	
	
//	@PostMapping("/memberView")
//	public String memberView(@RequestParam(required=false) String id, @RequestParam(required=false) String pw	
//			//@RequestParam(required=false) 쓰면 빈 값을 받아도 된다는 뜻. 이거 안쓰고 회원가입시 빈 칸 있으면 오류뜸
//			, @RequestParam(required=false) String name, @RequestParam(defaultValue="010-1111-1111", required=false) String phone
//			, @RequestParam(required=false) String gender, @RequestParam(required=false) String[] hobbys, Model model) {
//		
//		for(int i = 0; i< hobbys.length; i++) {
//			if(i == 0) hobby += hobbys[i];
//			else hobby += "," + hobbys[i];
//		}
//		model.addAttribute("id", id);
//		model.addAttribute("pw", pw);
//		model.addAttribute("name", name);
//		model.addAttribute("phone", phone);
//		model.addAttribute("gender", gender);
//		model.addAttribute("hobby", hobby);
//		
//		return "member/memberView";
//	} // memberView - @RequestParam 형태
	
	
	
//	@PostMapping("/memberView")	
//	public String memberView(HttpServletRequest request, Model model) {	// memberView - requset형태
//		
//		id = request.getParameter("id");
//		pw = request.getParameter("pw");
//		name = request.getParameter("name");
//		phone = request.getParameter("phone");
//		gender = request.getParameter("gender");
//		hobbys = request.getParameterValues("hobbys");
//		for(int i = 0; i< hobbys.length; i++) {
//			if(i == 0) hobby += hobbys[i];
//			else hobby += "," + hobbys[i];
//		}
//		model.addAttribute("id", id);
//		model.addAttribute("pw", pw);
//		model.addAttribute("name", name);
//		model.addAttribute("phone", phone);
//		model.addAttribute("gender", gender);
//		model.addAttribute("hobby", hobby);
//		
//		return "member/memberView";
//	} // memberView - requset 형태
	
	
	
	
}//class
