package com.spring.ex.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.spring.ex.bean.MartBean;
import com.spring.ex.dao.MartDao;

public class MInsertCommand implements MCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		MartBean mb = (MartBean)map.get("mb");
		
		if(mb.getAgree() != null) {
			mb.setAgree("동의함");
		}else {
			mb.setAgree("동의안함");
		}
		
		MartDao mdao = MartDao.getInstance();
		mdao.insertMart(mb);
		
	}

}
