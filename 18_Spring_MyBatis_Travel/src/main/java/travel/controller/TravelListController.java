package travel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;
import utility.Paging;

@Controller
public class TravelListController {
	
	private final String command = "/list.tv";
	private String listPage = "travelList";
	
	@Autowired
	TravelDao tdao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(@RequestParam(value="col", required = false) String col, 
								@RequestParam(value="keyword", required = false) String keyword,
								@RequestParam(value="pageNumber", required = false) String pageNumber,
								HttpServletRequest request) {
		
		System.out.println("col: "+col);
		System.out.println("keyword: "+keyword);
		System.out.println("pageNumber: "+pageNumber);
		
		Map<String, String> map = new HashMap<String,String>();
		map.put("col", col);
		map.put("keyword", "%"+keyword+"%");
		
		String pageSize = "3";
		int totalCount = tdao.getTotalCount(map);
		String url = request.getContextPath()+command;
		
		/* Paging ��ü �����ڷ� �� ����
		   - pageNumber: ����ڰ� ������ ��������ȣ, pageSize: �� �������� ������ ���ڵ� ����
		   - totalCount: ��ü ���ڵ� ���� or �˻���� ����,
		   - url: �⺻��ġ+��û��, col: �˻��� �÷�, keyword: �˻� Ű���� */
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, col, keyword, null);
		
		List<TravelBean> lists = tdao.getAllTravel(map,pageInfo); 
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("lists", lists);
		
		mav.setViewName(listPage);
		
		return mav;
	}
}