package com.spring.ex.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.spring.ex.bean.MartBean;
import com.spring.ex.dao.MartDao;

public class MUpdateFormCommand implements MCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		int num = (Integer)map.get("num");
		
		MartDao mdao = MartDao.getInstance();
		MartBean mb = mdao.getMartbyNum(num);
		
		if(mb.getAgree().equals("동의안함")) {
			mb.setAgree(null);
		}
		
		model.addAttribute("mb", mb);
		
	}

}
