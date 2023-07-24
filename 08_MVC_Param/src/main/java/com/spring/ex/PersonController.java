package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {
	
	/* result1.jsp */
	//http://localhost:8080/ex/person/input?name=kim&age=20 (get방식으로 parameter 값 넘김)
	@RequestMapping("person/input")
	public String input(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("name: "+name);
		System.out.println("age: "+age);
		
		model.addAttribute("name", name+"님");
		model.addAttribute("age", age+"살");
		
		//dispatcher.forward(request,response); -> 자동으로 request,response 객체가 넘어감
		return "person/result1";
	}
	
	/* result2.jsp */
	//http://localhost:8080/ex/person/input2?id=kim&passwd=1234&addr=seoul (get방식으로 parameter 값 넘김)
	@RequestMapping("person/input2")
	public String input2(@RequestParam("id") String id, @RequestParam("passwd") String passwd, 
															@RequestParam("addr") String juso, Model model) {
		
		//String id = request.getParameter("id");
		System.out.println("id: "+id);
		System.out.println("passwd: "+passwd);
		System.out.println("addr: "+juso);
		
		PersonBean pb = new PersonBean();
		pb.setId(id);
		pb.setPasswd(passwd);
		pb.setAddr(juso);
		
		model.addAttribute("pb", pb);
		
		return "person/result2";
	}
	
	/* form.jsp -> result3.jsp */
	@RequestMapping("person/form")
	public String form() {
		return "person/form";
	}
	@RequestMapping("person/input3")
	public String input3() {
		
		return "person/result3";
	}
	
	/* form2.jsp -> result4.jsp */
	@RequestMapping("person/form2")
	public String form2() {
		return "person/form2";
	}
	@RequestMapping("person/input4")
	public String input4(PersonBean per) {	//PersonBean per -> 커맨드 객체
		/* 매개변수를 참조변수(PersonBean per)로 설정하면 아래 작업들이 자동으로 실행됨
		   
		   String id = request.getParameter("id");
		   String passwd = request.getParameter("passwd");
		   String addr = request.getParameter("addr");
		   
		   PersonBean per = new PersonBean();
		   per.setId(id);
		   per.setPasswd(passwd);
		   per.setAddr(addr);
		   
		   model.addAttribute("personBean",per); -> 클래스명에서 첫번째 문자만 소문자로 변경한 변수에 bean 담음
		*/
		System.out.println(per.getId()+"/"+per.getPasswd()+"/"+per.getAddr());
		
		return "person/result4";
	}
	
	/* form3.jsp -> result5.jsp */
	@RequestMapping("person/form3")
	public String form3() {
		return "person/form3";
	}
	@RequestMapping("person/input5")
	public String input5(@ModelAttribute("abcd") PersonBean per) {
		// model.addAttribute("abcd",per);
		
		return "person/result5";
	}
	
}
