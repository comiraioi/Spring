package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardArticleController {
	private final String command = "/article.bd";
	private String getPage = "boardArticle";
	
	@Autowired
	BoardDao bdao;
	
	@RequestMapping(command)
	public String doAction(@RequestParam("num") int num, @RequestParam("pageNumber") int pageNumber, Model model) {
		BoardBean article = bdao.getArticlebyNum(num);
		
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("article", article);
		
		return getPage;
	}
}
