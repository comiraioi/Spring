package com.spring.ex.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.spring.ex.dao.MartDao;

public class MChkDeleteCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		String[] numArr = (String[])map.get("numArr");
		
		MartDao mdao = MartDao.getInstance();
		mdao.deleteMartbyChk(numArr);
		
	}

}
