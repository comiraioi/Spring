package com.spring.ex;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	
	@RequestMapping("form")
	public String form() {
		return "form";
	}
	
	//form action="input"
	@RequestMapping("input")
	public String input(HttpServletRequest request, RedirectAttributes redirectAttr) {	//form�� request ��ü
		
		System.out.println("====input()====");
		String name = request.getParameter("name");
		System.out.println("name: "+name);	//form���� �Է��� �̸�
		
		request.setAttribute("aname", name);
		
		/* �÷���: Map(Ű,��) */
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("mname", name);	//map�� (Ű,��) ���
		
		redirectAttr.addFlashAttribute("redirectMap",map);	//map ��ü �Ӽ�����
		
		//return "result";	-> result.jsp
		return "redirect:/input2";	//input2 ��û
	}
	
	@RequestMapping("input2")
	public String input2(HttpServletRequest request, RedirectAttributes redirectAttr) {	//input2�� request ��ü
		
		System.out.println("====input2()====");
		String name = request.getParameter("name");
		System.out.println("name: "+name);	//null -> form���� �Է��� ���� �Ѿ���� ����(request ��ü�� �ٸ�)
		
		String aname = (String)request.getAttribute("aname");
		System.out.println("aname: "+aname);	//null -> request �Ӽ� �����ص� �Ѿ���� ����
		
		Map<String,?> map = redirectAttr.getFlashAttributes();	//�Ӽ� ������ map ��������
		String mname = (String)map.get("mname");	//map�� ����ִ� mname�� �� ��������
		System.out.println("mname: "+mname);	//null -> result������ ${redirectMap.mname} ��µ�
		
		return "result";	//result.jsp
	}
	
	
}
