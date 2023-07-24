package com.spring.ex.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.spring.ex.bean.MartBean;
import com.spring.ex.dao.MartDao;

public class MListCommand implements MCommand {

	@Override
	public void execute(Model model) {
		
		MartDao mdao = MartDao.getInstance();
		ArrayList<MartBean> lists = mdao.getAllMart();
		
		model.addAttribute("lists", lists);
		
	}

}
