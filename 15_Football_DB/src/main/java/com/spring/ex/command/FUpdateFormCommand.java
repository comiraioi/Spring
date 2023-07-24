package com.spring.ex.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.spring.ex.dao.FDao;
import com.spring.ex.dto.FDto;

public class FUpdateFormCommand implements FCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int num = (Integer)map.get("num");
		
		FDao fdao = FDao.getInstance();
		FDto fb = fdao.getFootballbyNum(num);
		
		model.addAttribute("fb", fb);
	}

}
