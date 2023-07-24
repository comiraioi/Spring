package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Controller 어노테이션 반드시 작성해야 실행됨
@Controller		
@RequestMapping("board")	//동일 폴더명이면 클래스 밖에 RequestMapping 어노테이션으로 작성 가능
public class ExamController {
	
	@RequestMapping("/form")	//"board/form" 요청
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView("board/form");	//뷰 위치는 생략 불가능
		
		return mav;
	}
	
	@RequestMapping("/list")	//"board/list" 요청
	public ModelAndView list() {	//메서드명은 동일해도 상관 없음
		ModelAndView mav = new ModelAndView();
		/* 모델 */
		mav.addObject("name", "아이유");
		mav.addObject("age", "23");
		mav.setViewName("board/list");	//뷰
		
		return mav;
	}
	
	/* 다른 클래스에 작성해도 같은 프로젝트 안에서 요청명이 중복되면 안됨
	@RequestMapping("/member/list")	-> HomeController.java에 있음
	public ModelAndView list() {	
		ModelAndView mav = new ModelAndView();
		//모델
		mav.addObject("name", "윤아");
		mav.addObject("age", "30");
		mav.setViewName("member/list");	//뷰
		
		return mav;
	}
	*/
	
}
