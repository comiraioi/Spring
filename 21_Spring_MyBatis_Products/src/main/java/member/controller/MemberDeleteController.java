package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberDao;

@Controller
public class MemberDeleteController {
	
	private final String command = "/delete.mb";
	private String listPage = "redirect:/list.mb";
	
	@Autowired
	MemberDao mdao;
	
	@RequestMapping(value=command)
	public String doAction(@RequestParam("id") String id, @RequestParam("pageNumber") int pageNumber, Model model) {
		
		int cnt = mdao.deleteMember(id);
		
		if(cnt!=-1) {
			System.out.println("delete 성공");
		}else {
			System.out.println("delete 실패");
		}
		
		model.addAttribute("pageNumber", pageNumber);
		
		return listPage;
	}
	
}
