package movie.controller;

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

import movie.model.MovieBean;
import movie.model.MovieDao;

@Controller
public class MovieInsertController {
	private final String command = "/insert.mv";
	private String formPage = "movieInsertForm";
	private String listPage = "redirect:/list.mv";
	
	@Autowired
	MovieDao mdao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String insertForm() {
		return formPage;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("mb") @Valid MovieBean mb, BindingResult result) {
		int cnt = -1;
		ModelAndView mav = new ModelAndView();
		
		System.out.println("error: "+result.hasErrors());
		if(result.hasErrors()) {
			mav.setViewName(formPage);
		}
		
		cnt = mdao.insertMovie(mb);
		System.out.println("cnt: "+cnt);
		
		if(cnt!=-1) {
			System.out.println("insert 성공");
			mav.setViewName(listPage);
		}else {
			System.out.println("insert 실패");
			mav.setViewName(formPage);
		}
		
		return mav;
	}
}
