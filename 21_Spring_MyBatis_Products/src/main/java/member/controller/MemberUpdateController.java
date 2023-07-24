package member.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;
import utility.Paging;

@Controller
public class MemberUpdateController {
	
	private final String command = "/update.mb";
	private String formPage = "memberUpdateForm";
	private String listPage = "redirect:/list.mb";
	
	@Autowired
	MemberDao mdao;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction(@RequestParam("id") String id, @RequestParam("pageNumber") int pageNumber, Model model) {
		MemberBean mb = mdao.getMemberbyId(id);
		
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("mb", mb);
		
		return formPage;
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("mb") @Valid MemberBean mb, BindingResult result,
							@RequestParam("pageNumber") int pageNumber) {
		ModelAndView mav = new ModelAndView();
		
		System.out.println("error: "+result.hasErrors());
		if(result.hasErrors()) {
			mav.setViewName(formPage);
		}
		
		int cnt = mdao.updateMember(mb);
		
		if(cnt!=-1) {
			System.out.println("update 성공");
			mav.addObject("pageNumber", pageNumber);
			mav.setViewName(listPage);
		}else {
			System.out.println("update 실패");
			mav.setViewName(formPage);
		}
		
		return mav;
	}
	
}
