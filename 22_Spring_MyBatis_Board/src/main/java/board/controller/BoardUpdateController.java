package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardUpdateController {
	private final String command = "/update.bd";
	private String getPage = "articleUpdateForm";
	private String gotoPage = "redirect:/list.bd";
	
	@Autowired
	BoardDao bdao;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction(@RequestParam("num") int num, @RequestParam("pageNumber") int pageNumber, Model model) {
		BoardBean article = bdao.getArticlebyNum(num);
		
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("article", article);
		
		return getPage;
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("article") BoardBean article, @RequestParam("pageNumber") int pageNumber,
							HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		ModelAndView mav = new ModelAndView();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		
		if(article.getWriter() == "") {		//�ۼ��� ����
			out = response.getWriter();
			out.println("<script>alert('�̸��� �Է��ϼ���'); history.go(-1);</script>");
			out.flush();
			mav.setViewName(getPage);
		}else if(article.getSubject() == "") {	//���� ����
			out = response.getWriter();
			out.println("<script>alert('������ �Է��ϼ���'); history.go(-1);</script>");
			out.flush();
			mav.setViewName(getPage);
		}else if(article.getEmail() == "") {	//�̸��� ����
			out = response.getWriter();
			out.println("<script>alert('�̸����� �Է��ϼ���'); history.go(-1);</script>");
			out.flush();
			mav.setViewName(getPage);
		}else if(article.getContent() == "") {	//���� ����
			out = response.getWriter();
			out.println("<script>alert('������ �Է��ϼ���'); history.go(-1);</script>");
			out.flush();
			mav.setViewName(getPage);
		}else if(article.getPasswd() == "") {	//��й�ȣ ����
			try {
				out = response.getWriter();
				out.println("<script>alert('��й�ȣ�� �Է��ϼ���'); history.go(-1);</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mav.setViewName(getPage);
		}else {
			Map<String,String> map = new HashMap<String,String>();
			map.put("num", String.valueOf(article.getNum()));	
			map.put("passwd", article.getPasswd());				
			
			int count = bdao.searchPasswd(map);
			System.out.println("count:"+count);
			
			//��й�ȣ�� ��ġ�ϸ�
			if(count == 1) {	
				article.setIp(request.getRemoteAddr()); 
				
				int cnt = bdao.updateArticle(article);
				if(cnt!=-1) {
					System.out.println("�� ���� ����");
					
					mav.addObject("pageNumber", pageNumber);
					mav.setViewName(gotoPage);
				}else {
					System.out.println("�� ���� ����");
					mav.setViewName(getPage);
				}
			}else {
				System.out.println("��й�ȣ ����ġ");
				
				try {
					out = response.getWriter();
					out.println("<script>alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�'); history.go(-1);</script>");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				mav.setViewName(getPage);
			}
		}
		
		return mav;
	}
}
