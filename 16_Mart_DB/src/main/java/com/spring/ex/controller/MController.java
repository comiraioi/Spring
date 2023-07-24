package com.spring.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ex.bean.MartBean;
import com.spring.ex.command.MChkDeleteCommand;
import com.spring.ex.command.MCommand;
import com.spring.ex.command.MDeleteCommand;
import com.spring.ex.command.MInsertCommand;
import com.spring.ex.command.MListCommand;
import com.spring.ex.command.MUpdateCommand;
import com.spring.ex.command.MUpdateFormCommand;

@Controller
public class MController {
	MCommand command;

	@RequestMapping(value="insert", method = RequestMethod.GET)
	public String insertForm() {
		return "insertForm";
	}
	
	@RequestMapping(value="insert", method = RequestMethod.POST)
	public String insert(Model model, @ModelAttribute("mb") @Valid MartBean mb, BindingResult result) {
		
		System.out.println("error: "+result.hasErrors());
		
		if(result.hasErrors()) {
			return "insertForm";
		}else {
			model.addAttribute("mb", mb);
			
			command = new MInsertCommand();
			command.execute(model);
			
			return "redirect:/list";
		}

	}
	
	@RequestMapping("list")
	public String list(Model model) {
		
		command = new MListCommand();
		command.execute(model);
			
		return "list";
	}
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public String updateForm(Model model, HttpServletRequest request) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		model.addAttribute("num", num);
		
		command = new MUpdateFormCommand();
		command.execute(model);
		
		return "updateForm";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute("mb") @Valid MartBean mb, BindingResult result) {
		System.out.println("error:"+result.hasErrors());
		
		if(result.hasErrors()) {
			return "updateForm";
		}else {
			model.addAttribute("mb",mb);
			
			command = new MUpdateCommand();
			command.execute(model);
			
			return "redirect:/list";
		}
	
	}
	
	@RequestMapping(value="delete")
	public String delete(Model model, HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		model.addAttribute("num", num);
		
		command = new MDeleteCommand();
		command.execute(model);
		
		return "redirect:/list";
	}
	
	@RequestMapping("deleteChk")
	public String chkDelete(Model model, HttpServletRequest request) {
		
		String[] numArr = request.getParameterValues("numChk");
		for(int i=0; i<numArr.length; i++) {
			System.out.println(numArr[i]);
		}
		
		model.addAttribute("numArr", numArr);
		
		command = new MChkDeleteCommand();
		command.execute(model);
		
		return "redirect:/list";
	}
	
}
