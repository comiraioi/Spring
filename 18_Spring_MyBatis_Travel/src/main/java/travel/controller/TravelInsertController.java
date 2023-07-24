package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelInsertController {
	
	private final String command = "/insert.tv";
	private String formPage = "travelInsertForm";
	private String listPage = "redirect:/list.tv";
	
	@Autowired
	TravelDao tdao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String insertForm() {
		return formPage;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("tb") @Valid TravelBean tb, BindingResult result) {
		int cnt = -1;
		ModelAndView mav = new ModelAndView();
		
		System.out.println("error: "+result.hasErrors());
		
		if(result.hasErrors()) {
			mav.setViewName(formPage);
		}
		else {
			cnt = tdao.insertTravel(tb);
			if(cnt!=-1) {
				System.out.println("insert 성공");
				mav.setViewName(listPage);
			}else {
				System.out.println("insert 실패");
				mav.setViewName(formPage);
			}
		}
		
		return mav;
	}
}