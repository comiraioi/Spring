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
public class BoardDeleteController {
	private final String command = "/delete.bd";
	private String getPage = "articleDeleteForm";
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
	public ModelAndView delete(@RequestParam("num") int num, @RequestParam("pageNumber") int pageNumber,
			@RequestParam("passwd") String passwd, HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		
		System.out.println("입력한 비밀번호: "+passwd);
		if(passwd == "") {	//비밀번호 입력 안하면
			try {
				out = response.getWriter();
				out.println("<script>alert('비밀번호를 입력하세요'); history.go(-1);</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			mav.setViewName(getPage);
		}else {

			Map<String,String> map = new HashMap<String,String>();
			map.put("num", String.valueOf(num));	//글 번호
			map.put("passwd", passwd);				//입력한 비빌번호
			
			int count = bdao.searchPasswd(map);
			System.out.println("count:"+count);
			
			//비밀번호가 일치하면
			if(count == 1) {	
				int cnt = bdao.deleteArticle(num);
				if(cnt!=-1) {
					System.out.println("글 삭제 성공");
					
					mav.addObject("pageNumber", pageNumber);
					mav.setViewName(gotoPage);
				}else {
					System.out.println("글 삭제 실패");
					mav.setViewName(getPage);
				}
			}else {
				System.out.println("비밀번호 불일치");
				
				try {
					out = response.getWriter();
					out.println("<script>alert('비밀번호가 일치하지 않습니다'); history.go(-1);</script>");
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
