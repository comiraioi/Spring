package product.controller;

import java.io.File;
import java.io.IOException;
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
public class ProductUpdateController {
	
	private final String command = "/update.prd";
	private String formPage = "productUpdateForm";
	private String listPage = "redirect:/list.prd";
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction(@RequestParam("num") int num, @RequestParam("pageNumber") int pageNumber, Model model) {
		ProductBean pb = pdao.getProductbyNum(num);
		
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("pb", pb);
		
		return formPage;
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("pb") @Valid ProductBean pb, BindingResult result,
							@RequestParam("pageNumber") int pageNumber) {
		ModelAndView mav = new ModelAndView();
		
		/* ���ο� �̹����� ���ε����� ���� ��� */
		if(pb.getImage().equals("")) {
			pb.setImage(pb.getUpload2());	//���� �̹��� �ֱ�
		}
		
		System.out.println("error: "+result.hasErrors());
		if(result.hasErrors()) {
			mav.setViewName("productUpdateForm");
		}else {
			//resources ���� ���
			String folderPath = servletContext.getRealPath("/resources");
					
			//���� �̹��� ����
			File prevImage = new File(folderPath + File.separator + pb.getUpload2());

			boolean flag = prevImage.delete();
			if(flag==true) {
				System.out.println("�̹��� ���� ����");
			}else {
				System.out.println("�̹��� ���� ����");
			}
		
			//���ο� �̹��� ����
			File newImage = new File(folderPath+File.separator+pb.getUpload().getOriginalFilename());
			
			MultipartFile multi = pb.getUpload();
			
			int cnt = pdao.updateProduct(pb);
			if(cnt!=-1) {
				try {
					multi.transferTo(newImage);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				System.out.println("update ����");
				mav.addObject("pageNumber", pageNumber);
				mav.setViewName(listPage);
			}else {
				System.out.println("update ����");
				mav.setViewName("productUpdateForm");
			}
		}
		
		return mav;
	}
	
}
