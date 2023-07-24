package recipe.controller;

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

import recipe.model.RecipeBean;
import recipe.model.RecipeDao;

@Controller
public class RecipeInsertController {
	private final String command = "/insert.rc";
	private String formPage = "recipeInsertForm";
	private String listPage = "redirect:/list.rc";
	
	@Autowired
	RecipeDao rdao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String insertForm() {
		return formPage;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("rb") @Valid RecipeBean rb, BindingResult result) {
		int cnt = -1;
		ModelAndView mav = new ModelAndView();
		
		System.out.println("error: "+result.hasErrors());
		if(result.hasErrors()) {
			mav.setViewName(formPage);
		}
		
		cnt = rdao.insertRecipe(rb);
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
