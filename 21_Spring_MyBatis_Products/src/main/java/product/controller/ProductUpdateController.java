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
		
		/* 새로운 이미지를 업로드하지 않은 경우 */
		if(pb.getImage().equals("")) {
			pb.setImage(pb.getUpload2());	//기존 이미지 넣기
		}
		
		System.out.println("error: "+result.hasErrors());
		if(result.hasErrors()) {
			mav.setViewName("productUpdateForm");
		}else {
			//resources 폴더 경로
			String folderPath = servletContext.getRealPath("/resources");
					
			//기존 이미지 파일
			File prevImage = new File(folderPath + File.separator + pb.getUpload2());

			boolean flag = prevImage.delete();
			if(flag==true) {
				System.out.println("이미지 삭제 성공");
			}else {
				System.out.println("이미지 삭제 실패");
			}
		
			//새로운 이미지 파일
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
				
				System.out.println("update 성공");
				mav.addObject("pageNumber", pageNumber);
				mav.setViewName(listPage);
			}else {
				System.out.println("update 실패");
				mav.setViewName("productUpdateForm");
			}
		}
		
		return mav;
	}
	
}
