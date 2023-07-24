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
public class MovieUpdateController {
	private final String command = "/update.mv";
	private String formPage = "movieUpdateForm";
	private String listPage = "redirect:/list.mv";
	
	@Autowired
	MovieDao mdao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String updateForm(@RequestParam("num") int num, @RequestParam("pageNumber") int pageNumber, Model model) {
		MovieBean mb = mdao.getMoviebyNum(num);
		
		model.addAttribute("mb", mb);
		model.addAttribute("pageNumber", pageNumber);
		
		return formPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(@RequestParam("pageNumber") int pageNumber,
								@ModelAttribute("mb") @Valid MovieBean mb, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber", pageNumber);
		
		if(result.hasErrors()) {
			mav.setViewName(formPage);
		}else {
			int cnt = mdao.updateMovie(mb);
			
			if(cnt != -1) {
				System.out.println("update 성공");
				mav.setViewName(listPage);
			}else {
				System.out.println("update 실패");
				mav.setViewName(formPage);
			}
		}
		
		return mav;
	}
	
}
