package com.spring.ex.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.spring.ex.dao.FDao;
import com.spring.ex.dto.FDto;

public class FUpdateCommand implements FCommand{

	@Override
	public void execute(Model model) {
		Map<String,Object> map =  model.asMap();
		FDto fb = (FDto)map.get("fb");
		
		FDao fdao = FDao.getInstance();
		fdao.updateFootball(fb);
	}

}
