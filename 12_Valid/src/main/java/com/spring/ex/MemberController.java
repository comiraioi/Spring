package com.spring.ex;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String form() {
		return "form";
	}
	
	@RequestMapping(value="form", method=RequestMethod.POST)
	public String input(@Valid MemberBean mb, BindingResult result) {	//Ŀ�ǵ� ��ü ������ ��ȿ�� �˻�
		
		String page = "result";		//false: mb�� setter�� �� ���� -> result.jsp
		
		if(result.hasErrors()) {	//true: ���� �߻� -> form.jsp
			System.out.println("error: "+result.hasErrors());
			return "form";
		}
		
		System.out.println("error: "+result.hasErrors());
		return page;
	}
	
	
}
