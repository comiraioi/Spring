package com.spring.ex.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.spring.ex.dao.FDao;

public class FDeleteCommand implements FCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int num = (Integer)map.get("num");
		
		FDao fdao = FDao.getInstance();
		fdao.deleteFootball(num);
	}

}
