package com.spring.ex.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ex.Dto.PDto;
import com.spring.ex.command.PCommand;
import com.spring.ex.command.PDeleteCommand;
import com.spring.ex.command.PListCommand;
import com.spring.ex.command.PUpdateCommand;
import com.spring.ex.command.PUpdateFormCommand;
import com.spring.ex.command.PWriteCommand;

@Controller
public class PController {
	PCommand command = null;
	
	@RequestMapping(value="writeform")
	public String form() {
		return "write_form";
	}
	
	@RequestMapping(value="write")
	public String write(Model model, HttpServletRequest request) {
		System.out.println("write()");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(id+"/"+name+"/"+age);
		
		model.addAttribute("req",request);	//request 객체(form에서 입력한 데이터) 모델 속성 설정
		
		command = new PWriteCommand();	//부모타입으로 자식객체 관리
		command.execute(model);	//model 객체 안에 request 객체 담겨있음
		
		return "redirect:/list";	//list 요청
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		System.out.println("list()");
		
		command = new PListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("updateform")
	public String updateform(Model model, HttpServletRequest request) {
		System.out.println("updateform()");
		
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("num: "+num);
		model.addAttribute("num",num);
		
		command = new PUpdateFormCommand();
		command.execute(model);
		
		return "update_form";
	}
	
	@RequestMapping("update")
	public String update(Model model, HttpServletRequest request) {
		System.out.println("update()");
		
		model.addAttribute("req",request);
		
		command = new PUpdateCommand();
		command.execute(model);
		
		return "redirect:/list";
	}
	
	@RequestMapping("delete")
	public String delete(Model model, HttpServletRequest request) {
		System.out.println("delete()");
		
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("num: "+num);
		model.addAttribute("num",num);
		
		command = new PDeleteCommand();
		command.execute(model);
		
		return "redirect:/list";
	}
	
}
