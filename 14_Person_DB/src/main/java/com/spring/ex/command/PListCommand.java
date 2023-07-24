package com.spring.ex.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.Dao.PDao;
import com.spring.ex.Dto.PDto;

public class PListCommand implements PCommand {

	@Override
	public void execute(Model model) {
		System.out.println("===PListCommand===");
		
		PDao pdao = PDao.getInstance();
		ArrayList<PDto> lists = pdao.getAllPerson();
		model.addAttribute("lists", lists);
	}

}
