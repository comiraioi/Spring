package com.spring.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ex.command.FCommand;
import com.spring.ex.command.FDeleteCommand;
import com.spring.ex.command.FInsertCommand;
import com.spring.ex.command.FListCommand;
import com.spring.ex.command.FUpdateCommand;
import com.spring.ex.command.FUpdateFormCommand;
import com.spring.ex.dto.FDto;

@Controller
public class FController {
	FCommand command = null;
	
	@RequestMapping(value="insert", method = RequestMethod.GET)
	public String form() {
		return "insertForm";
	}
	
	@RequestMapping(value="insert", method = RequestMethod.POST)
	public String insert(Model model, HttpServletRequest request, @ModelAttribute("fDto") @Valid FDto fb, BindingResult result) {
		
		/* 매개변수 커맨드객체(bean): 자동으로 객체 생성, setter 주입, model 속성설정(bean 앞글자만 소문자)
	       => 자동 설정된 model은 java 파일로 가져갈 수 없음(jsp파일만 가능)
	       => model.add("fDto", fb); 직접 작성하거나 매개변수로 @ModelAttribute("fDto") 작성 		*/
		
		System.out.println("error: "+result.hasErrors());
		if(result.hasErrors()) {
			return "insertForm";
		}
		else {
			/* request
			model.addAttribute("req", request); */
			
			model.addAttribute("fb", fb);	//setter 주입 시 배열 자동 처리
			
			command = new FInsertCommand();
			command.execute(model);
			
			return "redirect:/list";
		}
		
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		
		command = new FListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public String updateform(Model model, HttpServletRequest request) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		model.addAttribute("num",num);
		
		command = new FUpdateFormCommand();
		command.execute(model);
		
		return "updateForm";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute("fb") @Valid FDto fb, BindingResult result) {
		
		System.out.println("error: "+result.hasErrors());
		
		if(result.hasErrors()) {
			return "updateForm";
		}
		else {
			model.addAttribute("fb", fb);
			
			command = new FUpdateCommand(); 
			command.execute(model);
			
			return "redirect:/list";
		}
		
	}
	
	@RequestMapping(value="delete")
	public String delete(Model model, HttpServletRequest request) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		model.addAttribute("num", num);
		
		command = new FDeleteCommand();
		command.execute(model);
		
		return "redirect:/list";
	}
	
	
}
