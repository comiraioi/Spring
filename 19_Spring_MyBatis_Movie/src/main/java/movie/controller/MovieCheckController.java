package movie.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import movie.model.MovieDao;

@Controller
public class MovieCheckController {
	private final String command = "dupl_check.mv";
	
	@Autowired
	MovieDao mdao;
	
	@RequestMapping(command)
	@ResponseBody	//뷰로 이동 x, return 값 => ajax로 반환
	public String check(@RequestParam("inputTitle") String inputTitle, HttpServletResponse response) {
		System.out.println("inputTitle: "+inputTitle);
		
		boolean result = mdao.searchTitle(inputTitle);
		System.out.println("result: "+result);
		
		if(result==false){
			System.out.println("중복");
			return "NO";	
		}else{
			System.out.println("사용 가능");
			return "YES";
		}
		
	}
}
