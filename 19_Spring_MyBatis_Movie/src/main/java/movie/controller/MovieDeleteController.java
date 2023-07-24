package movie.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import movie.model.MovieDao;

@Controller
public class MovieDeleteController {
	private final String command = "/delete.mv";
	private String listPage = "redirect:/list.mv";
	
	@Autowired
	MovieDao mdao;
	
	@RequestMapping(value=command)
	public String delete(@RequestParam("num") int num, @RequestParam("pageNumber") int pageNumber, Model model) {
		int cnt = -1;
		
		cnt = mdao.deleteMovie(num);
		System.out.println("cnt: "+cnt);
		
		if(cnt!=-1) {
			System.out.println("delete 성공");
		}else {
			System.out.println("delete 실패");
		}
		
		return listPage+"?pageNumber="+pageNumber;
	}
}
