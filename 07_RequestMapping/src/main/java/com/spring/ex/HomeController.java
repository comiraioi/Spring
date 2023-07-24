package com.spring.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/member/view")	//GET,POST ��� ��� ����
	public String view() {
		return "member.memberView";	//���ϸ� -> /WEB-INF/views/member.memberView.jsp
	}
	
	@RequestMapping("/member/input")
	public String input(Model model, HttpServletRequest request) {
		//id�� kim�� �־� model�� ��� view�� ������
		model.addAttribute("id","kim");
		request.setAttribute("pw","1234");
		
		return "member.insertForm";
	}
	
	@RequestMapping("/member/list")
	public ModelAndView list() {	//�޼������ �����ص� ��� ����
		ModelAndView mav = new ModelAndView();
		//��
		mav.addObject("name", "����");
		mav.addObject("age", "30");
		mav.setViewName("member/list");	//��
		
		return mav;
	}
	
	@RequestMapping("/member/list2")
	public ModelAndView list2() {
		ModelAndView mav = new ModelAndView("member/list2");
		
		return mav;
	}
}
