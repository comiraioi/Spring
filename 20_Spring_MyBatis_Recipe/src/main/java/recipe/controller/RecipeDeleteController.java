package recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import recipe.model.RecipeDao;

@Controller
public class RecipeDeleteController {
	private final String command = "/delete.rc";
	private String listPage = "redirect:/list.rc";
	
	@Autowired
	RecipeDao rdao;
	
	@RequestMapping(command)
	public String delete(@RequestParam("num") int num, @RequestParam("pageNumber") int pageNumber, Model model) {
		int cnt = -2;
		cnt = rdao.deleteRecipe(num);
		
		if(cnt!=-1) {
			System.out.println("delete 성공");
		}else {
			System.out.println("delete 실패");
		}
		
		model.addAttribute("pageNumber",pageNumber);
		return listPage;
	}
}
