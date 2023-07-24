package travel.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelDetailController {
	
	private final String command = "/detail.tv";
	private String detailPage = "travelDetailView";
	
	@Autowired
	TravelDao tdao;
	
	@RequestMapping(value=command)
	public String detail(@RequestParam("num") int num, Model model, HttpServletRequest request) {
		String pageNumber = request.getParameter("pageNumber");
		model.addAttribute("pageNumber",pageNumber);
		
		TravelBean tb = tdao.getTravelbyNum(num);
		model.addAttribute("tb",tb);
		return detailPage;
	}
	
}