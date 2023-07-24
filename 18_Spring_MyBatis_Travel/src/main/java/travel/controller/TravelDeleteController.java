package travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelDeleteController {
	
	private final String command = "/delete.tv";
	private String listPage = "redirect:/list.tv";
	
	@Autowired
	TravelDao tdao;
	
	@RequestMapping(value=command)
	public String delete(@RequestParam("num") int num, @RequestParam("pageNumber") int pageNumber, Model model) {
		int cnt = -1;
		cnt = tdao.deleteTravel(num);
		if(cnt!=-1) {
			System.out.println("delete 성공");
		}else {
			System.out.println("delete 실패");
		}
		
		model.addAttribute("pageNumber", pageNumber);
		return listPage;
	}
	
}