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
public class RecipeUpdateController {
	private final String command = "/update.rc";
	private String formPage = "recipeUpdateForm";
	private String listPage = "redirect:/list.rc";
	
	@Autowired
	RecipeDao rdao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String updateForm(@RequestParam("num") int num, @RequestParam("pageNumber") int pageNumber, Model model) {
		RecipeBean rb = rdao.getRecipebyNum(num);
		
		model.addAttribute("rb", rb);
		model.addAttribute("pageNumber", pageNumber);
		
		return formPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView update(@RequestParam("pageNumber") int pageNumber,
								@ModelAttribute("rb") @Valid RecipeBean rb, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber", pageNumber);
		
		if(result.hasErrors()) {
			mav.setViewName(formPage);
		}else {
			int cnt = rdao.updateRecipe(rb);
			
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
