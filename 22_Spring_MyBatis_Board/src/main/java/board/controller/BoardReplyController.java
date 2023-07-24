package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardReplyController {
	private final String command = "/reply.bd";
	private String getPage = "articleReplyForm";
	private String gotoPage = "redirect:/list.bd";
	
	@Autowired
	BoardDao bdao;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction(@RequestParam("ref") int ref, @RequestParam("restep") int restep, 
			@RequestParam("relevel") int relevel, @RequestParam("pageNumber") int pageNumber, Model model) {
		
		model.addAttribute("ref", ref);
		model.addAttribute("restep", restep);
		model.addAttribute("relevel", relevel);
		model.addAttribute("pageNumber", pageNumber);
		
		return getPage;
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView write(@ModelAttribute("article") BoardBean article, @RequestParam("ref") int ref, @RequestParam("restep") int restep,
							@RequestParam("relevel") int relevel, @RequestParam("pageNumber") int pageNumber,
							HttpServletRequest request, HttpServletResponse response) throws IOException {
		
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
			Map<String,Integer> map = new HashMap<String,Integer>();
			map.put("ref", ref);
			map.put("restep", restep);
			
			int cnt1 = bdao.updateRestep(map);
			
			if(cnt1!=-1) {
				System.out.println("restep update ����");
				
				//�θ𰪿��� 1 ������
				article.setRestep(restep+1);
				article.setRelevel(relevel+1);
				
				article.setIp(request.getRemoteAddr()); 
				
				int cnt2 = bdao.replyArticle(article);
				
				if(cnt2!=-1) {
					System.out.println("��� �ۼ� ����");
					mav.setViewName(gotoPage);
				}else {
					System.out.println("��� �ۼ� ����");
					mav.setViewName(getPage);
				}
			}else {
				System.out.println("restep update ����");
				mav.setViewName(getPage);
			}
			
		}
		
		return mav;
	}
}
