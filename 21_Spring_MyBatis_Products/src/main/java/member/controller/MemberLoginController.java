package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberLoginController {
	private final String command = "login.mb";
	private String formPage = "memberLoginForm";
	private String listPage = "redirect:/list.prd";
	
	@Autowired
	MemberDao mdao;
	
	/* 상품 리스트 페이지에서 상품 추가(ProductInsertController) 클릭 시 넘어옴 */
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction(HttpSession session) {
		System.out.println("loginInfo: "+session.getAttribute("loginInfo"));
		
		if(session.getAttribute("loginInfo") != null) {	//로그인 했으면
			session.setAttribute("destination", "redirect:/insert.prd");	
			return "redirect:/"+command;	//상품추가 페이지
		}else {	//로그인 안했으면
			return formPage;	//로그인 페이지
		}
		
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("id") String id, @RequestParam("password") String password,
								HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		
		System.out.println("id: "+id+" / pw: "+password);
		
		MemberBean mb = mdao.getMemberbyId(id);
		
		if(mb == null) {
			System.out.println("가입하지 않은 회원");
			
			try {
				out = response.getWriter();
				out.println("<script>alert('가입하지 않은 회원입니다'); history.go(-1);</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			mav.setViewName(formPage);
			
		}else {
			if(mb.getPassword().equals(password)) {
				System.out.println("로그인 성공");
				
				//로그인한 회원 정보 세션 설정
				session.setAttribute("loginInfo", mb);
				
				String destination = (String)session.getAttribute("destination");
				System.out.println("destination: "+destination);
				
				if(destination == null) {
					mav.setViewName(listPage);
				}else {
					mav.setViewName(destination);
					/* destination
					   - 경우1: 상품 리스트 페이지에서 상품 추가 클릭 (ProductInsertController)
					   		   => 로그인 안했으면 로그인 폼으로
					   		   => MemberLoginController에서 destination 속성 설정
					   		   => 로그인 처리 후 destination(insert.prd)으로 이동
					   - 경우2: 상품 디테일 페이지에서 주문 클릭 (CartAddController)
					   		   => 로그인 안했으면 destination 속성 설정 후 로그인 폼으로
					   		   => MemberLoginController에서 로그인 처리 후 destination(detail.prd+num&pageNumber)으로 이동
					*/
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
				
				mav.setViewName(formPage);
			}
		}
		
		return mav;
	}
}
