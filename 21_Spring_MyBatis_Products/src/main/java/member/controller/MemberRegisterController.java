package member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberRegisterController {
	private final String command = "register.mb";
	private String formPage = "memberRegisterForm";
	private String listPage = "redirect:/list.mb";
	
	@Autowired
	MemberDao mdao;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction() {
		return formPage;
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("mb") @Valid MemberBean mb, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		System.out.println("error: "+result.hasErrors());
		if(result.hasErrors()) {
			mav.setViewName(formPage);
		}
		
		int cnt = mdao.register(mb);
		if(cnt!=-1) {
			System.out.println("회원가입 성공");
			mav.setViewName(listPage);
		}else {
			System.out.println("회원가입 실패");
			mav.setViewName(formPage);
		}

		return mav;
	}
}
