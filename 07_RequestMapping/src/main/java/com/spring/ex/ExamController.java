package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Controller ������̼� �ݵ�� �ۼ��ؾ� �����
@Controller		
@RequestMapping("board")	//���� �������̸� Ŭ���� �ۿ� RequestMapping ������̼����� �ۼ� ����
public class ExamController {
	
	@RequestMapping("/form")	//"board/form" ��û
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView("board/form");	//�� ��ġ�� ���� �Ұ���
		
		return mav;
	}
	
	@RequestMapping("/list")	//"board/list" ��û
	public ModelAndView list() {	//�޼������ �����ص� ��� ����
		ModelAndView mav = new ModelAndView();
		/* �� */
		mav.addObject("name", "������");
		mav.addObject("age", "23");
		mav.setViewName("board/list");	//��
		
		return mav;
	}
	
	/* �ٸ� Ŭ������ �ۼ��ص� ���� ������Ʈ �ȿ��� ��û���� �ߺ��Ǹ� �ȵ�
	@RequestMapping("/member/list")	-> HomeController.java�� ����
	public ModelAndView list() {	
		ModelAndView mav = new ModelAndView();
		//��
		mav.addObject("name", "����");
		mav.addObject("age", "30");
		mav.setViewName("member/list");	//��
		
		return mav;
	}
	*/
	
}
