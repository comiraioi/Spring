package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.FDao;
import com.spring.ex.dto.FDto;

public class FInsertCommand implements FCommand{

	@Override
	public void execute(Model model) {
		
		/* request 객체로 받은 경우
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("req");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String win = request.getParameter("win");
		String round16 = "";
		
		String[] arr = request.getParameterValues("round16");
		if(arr.length == 0) {
			round16 += "선택 X";
		}else {
			for(int i=0; i<arr.length; i++) {
				round16 += arr[i];
				if(i!=arr.length-1) {
					round16+= ",";
				}
			}
		}
		
		FDto fb = new FDto(0,id,pw,win,round16);
		
		FDao fdao = FDao.getInstance();
		fdao.insertFootball(fb);
		*/
		
		/* 커맨드객체로 받은 경우 */
		Map<String, Object> map = model.asMap();
		FDto fb = (FDto)map.get("fb");
		
		FDao fdao = FDao.getInstance();
		fdao.insertFootball(fb);
		
	}

}
