package com.spring.ex;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	
	@RequestMapping("form")
	public String form() {
		return "form";
	}
	
	//form action="input"
	@RequestMapping("input")
	public String input(HttpServletRequest request, RedirectAttributes redirectAttr) {	//form의 request 객체
		
		System.out.println("====input()====");
		String name = request.getParameter("name");
		System.out.println("name: "+name);	//form에서 입력한 이름
		
		request.setAttribute("aname", name);
		
		/* 컬렉션: Map(키,값) */
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("mname", name);	//map에 (키,값) 담기
		
		redirectAttr.addFlashAttribute("redirectMap",map);	//map 객체 속성설정
		
		//return "result";	-> result.jsp
		return "redirect:/input2";	//input2 요청
	}
	
	@RequestMapping("input2")
	public String input2(HttpServletRequest request, RedirectAttributes redirectAttr) {	//input2의 request 객체
		
		System.out.println("====input2()====");
		String name = request.getParameter("name");
		System.out.println("name: "+name);	//null -> form에서 입력한 값이 넘어오지 않음(request 객체가 다름)
		
		String aname = (String)request.getAttribute("aname");
		System.out.println("aname: "+aname);	//null -> request 속성 설정해도 넘어오지 않음
		
		Map<String,?> map = redirectAttr.getFlashAttributes();	//속성 설정한 map 가져오기
		String mname = (String)map.get("mname");	//map에 담겨있는 mname의 값 가져오기
		System.out.println("mname: "+mname);	//null -> result에서는 ${redirectMap.mname} 출력됨
		
		return "result";	//result.jsp
	}
	
	
}
