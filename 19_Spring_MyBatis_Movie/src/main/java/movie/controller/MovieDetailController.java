package movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import movie.model.MovieBean;
import movie.model.MovieDao;

@Controller
public class MovieDetailController {
	private final String command = "/detail.mv";
	private String detailPage = "movieDetailView";
	
	@Autowired
	MovieDao mdao;
	
	@RequestMapping(command)
	public String detail(@RequestParam("num") int num, @RequestParam("pageNumber") int pageNumber, Model model){
		MovieBean mb = mdao.getMoviebyNum(num);
		
		model.addAttribute("mb", mb);
		model.addAttribute("pageNumber",pageNumber);
		
		return detailPage;
	}
}
