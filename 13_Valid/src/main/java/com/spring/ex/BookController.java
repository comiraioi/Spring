package com.spring.ex;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String form(HttpServletRequest request) {
		//System.out.println(request.getMethod());	-> 요청방식
		
		return "bookForm";
	}
	
	@RequestMapping(value="form", method=RequestMethod.POST)
	public String form(@Valid BookBean bb, BindingResult result) {
		
		System.out.println("error: "+result.hasErrors());
		
		if(result.hasErrors()) {
			return "bookForm";
		}
		else {
			return "result2";
		}
		
	}
	
}
