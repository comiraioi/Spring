package com.spring.ex;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirextController2 {

	@RequestMapping("form2")
	public String form2() {
		return "form2";
	}
	
	@RequestMapping("input3")
	public String input3(HttpServletRequest request, RedirectAttributes redirectAttr) {
		
		String title = request.getParameter("title");
		String singer = request.getParameter("singer");
		int price = Integer.parseInt(request.getParameter("price"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("singer", singer);
		map.put("price", price);
		
		redirectAttr.addFlashAttribute("map", map);
		
		return "redirect:/input4";
	}
	
	@RequestMapping("input4")
	public String input4() {
		return "result2";
	}
	
	
}
