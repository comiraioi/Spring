package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelUpdateController {
	
	private final String command = "/update.tv";
	private String formPage = "travelUpdateForm";
	private String listPage = "redirect:/list.tv";
	
	@Autowired
	TravelDao tdao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String updateForm(@RequestParam("num") int num, @RequestParam("pageNumber") int pageNumber, Model model) {
		TravelBean tb = tdao.getTravelbyNum(num);
		model.addAttribute("tb",tb);
		model.addAttribute("pageNumber",pageNumber);
		return formPage;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("tb") @Valid TravelBean tb, @RequestParam("pageNumber") int pageNumber, BindingResult result) {
		int cnt = -1;
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pageNumber", pageNumber);
		
		System.out.println("error: "+result.hasErrors());
		if(result.hasErrors()) {
			mav.setViewName(formPage);
		}
		else {
			cnt = tdao.updateTravel(tb);
			if(cnt!=-1) {
				System.out.println("update 성공");
				mav.setViewName(listPage);
			}else {
				System.out.println("update 실패");
				mav.setViewName("redirect:"+command+"?num="+tb.getNum()+"&pageNumber="+pageNumber);
			}
		}
		
		return mav;
	}
}