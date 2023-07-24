package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class ProductInsertController {
	
	private final String command = "/insert.prd";
	private String formPage = "productInsertForm";
	private String listPage = "redirect:/list.prd";
	private String loginPage = "redirect:/login.mb";
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction(HttpSession session) {	//session에 loginInfo 담겨있음
		System.out.println("loginInfo: " + session.getAttribute("loginInfo"));
		
		if(session.getAttribute("loginInfo") == null) {	//로그인 안했으면
			return loginPage;	//로그인 페이지로
		}else {
			return formPage;	//상품 추가 페이지로
		}
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public String insert(@ModelAttribute("pb") @Valid ProductBean pb,BindingResult result) {
		/* 이미지 업로드 경로 */
		String uploadPath = servletContext.getRealPath("/resources");
		System.out.println("uploadPath:"+uploadPath);
		// => 문자열 폴더로 인식하도록 File 객체 필요
	
		/* 업로드경로\abc.jpg */
		File destination = new File(uploadPath+File.separator+pb.getUpload().getOriginalFilename());
		System.out.println("image:"+uploadPath+File.separator+pb.getUpload().getOriginalFilename());
		
		/* 로컬 폴더 */
		String str = "c:/tempUpload";
		MultipartFile multi = pb.getUpload(); //MultipartFile 객체를 리턴하는 메서드
		File destination_local = new File(str + File.separator + multi.getOriginalFilename());
		
		if(result.hasErrors()) {
			return formPage;
		}else {
			int cnt = pdao.insertProduct(pb);
			
			if(cnt!=-1) {
				try {
					multi.transferTo(destination);
					
					//웹서버 폴더에 올린 이미지를 로컬 폴더에 복사
					FileCopyUtils.copy(destination, destination_local);	
					
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				System.out.println("insert 성공");
				return listPage;
			} else {
				System.out.println("insert 실패");
				return formPage;
			}
		}
	}
	
	
}
