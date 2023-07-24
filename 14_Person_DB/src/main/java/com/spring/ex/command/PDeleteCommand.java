package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.Dao.PDao;

public class PDeleteCommand implements PCommand{

	@Override
	public void execute(Model model) {
		System.out.println("===PDeleteCommand===");
		
		Map<String, Object> map = model.asMap();
		int num = (Integer)map.get("num");
		
		PDao pdao = PDao.getInstance();
		pdao.deletePerson(num);
		
	}

}
