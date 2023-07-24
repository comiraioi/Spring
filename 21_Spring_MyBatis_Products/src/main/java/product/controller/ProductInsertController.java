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
	public String doAction(HttpSession session) {	//session�� loginInfo �������
		System.out.println("loginInfo: " + session.getAttribute("loginInfo"));
		
		if(session.getAttribute("loginInfo") == null) {	//�α��� ��������
			return loginPage;	//�α��� ��������
		}else {
			return formPage;	//��ǰ �߰� ��������
		}
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public String insert(@ModelAttribute("pb") @Valid ProductBean pb,BindingResult result) {
		/* �̹��� ���ε� ��� */
		String uploadPath = servletContext.getRealPath("/resources");
		System.out.println("uploadPath:"+uploadPath);
		// => ���ڿ� ������ �ν��ϵ��� File ��ü �ʿ�
	
		/* ���ε���\abc.jpg */
		File destination = new File(uploadPath+File.separator+pb.getUpload().getOriginalFilename());
		System.out.println("image:"+uploadPath+File.separator+pb.getUpload().getOriginalFilename());
		
		/* ���� ���� */
		String str = "c:/tempUpload";
		MultipartFile multi = pb.getUpload(); //MultipartFile ��ü�� �����ϴ� �޼���
		File destination_local = new File(str + File.separator + multi.getOriginalFilename());
		
		if(result.hasErrors()) {
			return formPage;
		}else {
			int cnt = pdao.insertProduct(pb);
			
			if(cnt!=-1) {
				try {
					multi.transferTo(destination);
					
					//������ ������ �ø� �̹����� ���� ������ ����
					FileCopyUtils.copy(destination, destination_local);	
					
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				System.out.println("insert ����");
				return listPage;
			} else {
				System.out.println("insert ����");
				return formPage;
			}
		}
	}
	
	
}
