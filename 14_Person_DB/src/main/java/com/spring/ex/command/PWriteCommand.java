package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.Dao.PDao;

public class PWriteCommand implements PCommand {

	@Override
	public void execute(Model model) {
		System.out.println("===PWriteCommand===");
		
		Map<String, Object> map = model.asMap();	//Å°, °ª
		HttpServletRequest request = (HttpServletRequest)map.get("req");	//request °´Ã¼
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(id+"/"+name+"/"+age);
		
		PDao pdao = PDao.getInstance();
		pdao.write(id, name, Integer.parseInt(age));
		
	}

}
