package com.spring.ex.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.spring.ex.dao.FDao;
import com.spring.ex.dto.FDto;

public class FListCommand implements FCommand{

	@Override
	public void execute(Model model) {
		FDao fdao = FDao.getInstance();
		ArrayList<FDto> lists = fdao.getAllFootball();
		
		model.addAttribute("lists", lists);
	}

}
