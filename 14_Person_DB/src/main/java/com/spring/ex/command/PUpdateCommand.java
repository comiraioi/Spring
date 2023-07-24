package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.Dao.PDao;
import com.spring.ex.Dto.PDto;

public class PUpdateCommand implements PCommand{

	@Override
	public void execute(Model model) {
		System.out.println("===PUpdateCommand===");
		
		Map<String, Object> map = model.asMap();	
		HttpServletRequest request = (HttpServletRequest)map.get("req");
		
		PDto pb = new PDto();
		pb.setNum(Integer.parseInt(request.getParameter("num")));
		pb.setId(request.getParameter("id"));
		pb.setName(request.getParameter("name"));
		pb.setAge(Integer.parseInt(request.getParameter("age")));
		
		PDao pdao = PDao.getInstance();
		pdao.updatePerson(pb);
		
	}

}
