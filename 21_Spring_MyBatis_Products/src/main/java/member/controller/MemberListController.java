package member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;
import utility.Paging;

@Controller
public class MemberListController {
	private final String command = "/list.mb";
	private String listPage = "memberList";
	
	@Autowired
	MemberDao mdao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(@RequestParam(value="whatColumn",required=false) String whatColumn,
						@RequestParam(value="keyword",required=false) String keyword,
						@RequestParam(value="pageNumber",required=false) String pageNumber,
						HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(listPage);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		String pageSize = "5";
		int totalCount = mdao.getTotalCount(map);
		String url = request.getContextPath() + command;
		
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword, null);
		
		List<MemberBean> memberList = mdao.getAllMember(map, pageInfo);
		
		mav.addObject("memberList", memberList);
		mav.addObject("pageInfo", pageInfo);
		
		return mav;
	}
	
}
