package product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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

import product.model.ProductBean;
import product.model.ProductDao;
import utility.Paging;

@Controller
public class ProductDetailController {
	
	private final String command = "/detail.prd";
	private String detailPage = "productDetailView";
	
	@Autowired
	ProductDao pdao;
	
	@RequestMapping(value=command)
	public String doAction(@RequestParam("num") int num, @RequestParam("pageNumber") int pageNumber, Model model) {
		ProductBean pb = pdao.getProductbyNum(num);
		
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("pb", pb);
		
		return detailPage;
	}
	
}
