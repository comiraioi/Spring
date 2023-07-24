package product.controller;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import product.model.ProductBean;
import product.model.ProductDao;
import utility.Paging;

@Controller
public class ProductDeleteController {
	
	private final String command = "/delete.prd";
	private String listPage = "redirect:/list.prd";
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command)
	public String doAction(@RequestParam("num") int num, @RequestParam("pageNumber") int pageNumber, Model model) {
		
		ProductBean pb = pdao.getProductbyNum(num);
		int cnt = pdao.deleteProduct(num);
		
		if(cnt!=-1) {
			System.out.println("DB delete ����");
			
			//resources ���� ���
			String deletePath = servletContext.getRealPath("/resources");
		
			//�̹��� ���� ���
			File prdImage = new File(deletePath+File.separator+pb.getImage());
			System.out.println("������ �̹���: "+pb.getImage());
			
			boolean flag = prdImage.delete();
			if(flag==true) {
				System.out.println("�̹��� ���� ����");
			}else {
				System.out.println("�̹��� ���� ����");
			}
			
		}else {
			System.out.println("DB delete ����");
		}
		
		model.addAttribute("pageNumber", pageNumber);
		
		return listPage;
	}
	
}
