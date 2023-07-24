package recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import recipe.model.RecipeBean;
import recipe.model.RecipeDao;


@Controller
public class RecipeDetailController {
	private final String command = "/detail.rc";
	private String detailPage = "recipeDetailView";
	
	@Autowired
	RecipeDao rdao;
	
	@RequestMapping(command)
	public String detail(@RequestParam("num") int num, @RequestParam("pageNumber") int pageNumber, Model model){
		RecipeBean rb = rdao.getRecipebyNum(num);
		
		model.addAttribute("rb", rb);
		model.addAttribute("pageNumber",pageNumber);
		
		return detailPage;
	}
}
