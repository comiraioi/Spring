package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardWriteController {
	private final String command = "/write.bd";
	private String getPage = "articleWriteForm";
	private String gotoPage = "redirect:/list.bd";
	
	@Autowired
	BoardDao bdao;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView write(@ModelAttribute("article") BoardBean article,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		
		if(article.getWriter() == "") {		//작성자 누락
			out = response.getWriter();
			out.println("<script>alert('이름을 입력하세요'); history.go(-1);</script>");
			out.flush();
			mav.setViewName(getPage);
		}else if(article.getSubject() == "") {	//제목 누락
			out = response.getWriter();
			out.println("<script>alert('제목을 입력하세요'); history.go(-1);</script>");
			out.flush();
			mav.setViewName(getPage);
		}else if(article.getEmail() == "") {	//이메일 누락
			out = response.getWriter();
			out.println("<script>alert('이메일을 입력하세요'); history.go(-1);</script>");
			out.flush();
			mav.setViewName(getPage);
		}else if(article.getContent() == "") {	//내용 누락
			out = response.getWriter();
			out.println("<script>alert('내용을 입력하세요'); history.go(-1);</script>");
			out.flush();
			mav.setViewName(getPage);
		}else if(article.getPasswd() == "") {	//비밀번호 누락
			try {
				out = response.getWriter();
				out.println("<script>alert('비밀번호를 입력하세요'); history.go(-1);</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mav.setViewName(getPage);
		}else {
			article.setIp(request.getRemoteAddr()); 
			
			int cnt = bdao.writeArticle(article);
			if(cnt!=-1) {
				System.out.println("글 작성 성공");
				mav.setViewName(gotoPage);
			}else {
				System.out.println("글 작성 실패");
				mav.setViewName(getPage);
			}
		}
		
		
		return mav;
	}
}
