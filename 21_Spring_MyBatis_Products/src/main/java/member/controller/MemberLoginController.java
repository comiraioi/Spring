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
	
	/* ��ǰ ����Ʈ ���������� ��ǰ �߰�(ProductInsertController) Ŭ�� �� �Ѿ�� */
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction(HttpSession session) {
		System.out.println("loginInfo: "+session.getAttribute("loginInfo"));
		
		if(session.getAttribute("loginInfo") != null) {	//�α��� ������
			session.setAttribute("destination", "redirect:/insert.prd");	
			return "redirect:/"+command;	//��ǰ�߰� ������
		}else {	//�α��� ��������
			return formPage;	//�α��� ������
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
			System.out.println("�������� ���� ȸ��");
			
			try {
				out = response.getWriter();
				out.println("<script>alert('�������� ���� ȸ���Դϴ�'); history.go(-1);</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			mav.setViewName(formPage);
			
		}else {
			if(mb.getPassword().equals(password)) {
				System.out.println("�α��� ����");
				
				//�α����� ȸ�� ���� ���� ����
				session.setAttribute("loginInfo", mb);
				
				String destination = (String)session.getAttribute("destination");
				System.out.println("destination: "+destination);
				
				if(destination == null) {
					mav.setViewName(listPage);
				}else {
					mav.setViewName(destination);
					/* destination
					   - ���1: ��ǰ ����Ʈ ���������� ��ǰ �߰� Ŭ�� (ProductInsertController)
					   		   => �α��� �������� �α��� ������
					   		   => MemberLoginController���� destination �Ӽ� ����
					   		   => �α��� ó�� �� destination(insert.prd)���� �̵�
					   - ���2: ��ǰ ������ ���������� �ֹ� Ŭ�� (CartAddController)
					   		   => �α��� �������� destination �Ӽ� ���� �� �α��� ������
					   		   => MemberLoginController���� �α��� ó�� �� destination(detail.prd+num&pageNumber)���� �̵�
					*/
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
				
				mav.setViewName(formPage);
			}
		}
		
		return mav;
	}
}
