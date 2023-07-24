package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MusicController {

	@RequestMapping("form")
	public String form() {
		return "form";
	}
	
	@RequestMapping("input1")
	public String input1(HttpServletRequest request, Model model) {
		
		String title = request.getParameter("title");
		String singer = request.getParameter("singer");
		String price = request.getParameter("price");
		
		MusicBean mb = new MusicBean();
		mb.setTitle(title);
		mb.setSinger(singer);
		mb.setPrice(Integer.parseInt(price));
		
		model.addAttribute("mb",mb);
		
		return "music/result1";
	}
	
	@RequestMapping("input2")
	public String input2(@RequestParam("title") String title, @RequestParam("singer") String singer,
																	@RequestParam("price") String price, Model model) {
		MusicBean mb = new MusicBean();
		mb.setTitle(title);
		mb.setSinger(singer);
		mb.setPrice(Integer.parseInt(price));
		
		model.addAttribute("mb",mb);
		
		return "music/result2";
	}
	
	@RequestMapping("input3")
	public String input3(MusicBean mb) {
		return "music/result3";
	}
	
	@RequestMapping("input4")
	public String input4(@ModelAttribute("mb") MusicBean mb) {
		return "music/result4";
	}
	
	/*
	input1 요청 -> request로 받기
	input2 요청 -> @RequestParam으로
	input3 요청 -> command 객체
	input4 요청 -> 별칭 설정
	*/
	
}
