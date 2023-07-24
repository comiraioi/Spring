package com.spring.ex.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.Dao.PDao;
import com.spring.ex.Dto.PDto;

public class PUpdateFormCommand implements PCommand {

	@Override
	public void execute(Model model) {
		System.out.println("===PUpdateFormCommand===");
		
		Map<String, Object> map = model.asMap();	
		int num = (Integer)map.get("num");
		
		PDao pdao = PDao.getInstance();
		PDto pb = pdao.getPersonbyNum(num);
		
		model.addAttribute("pb", pb);
	}

}
