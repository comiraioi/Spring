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
		
		/* Paging 객체 생성자로 값 주입
		   - pageNumber: 사용자가 선택한 페이지번호, pageSize: 한 페이지에 보여질 레코드 갯수
		   - totalCount: 전체 레코드 갯수 or 검색결과 갯수,
		   - url: 기본위치+요청명, col: 검색할 컬럼, keyword: 검색 키워드 */
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, col, keyword, null);
		
		List<TravelBean> lists = tdao.getAllTravel(map,pageInfo); 
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("lists", lists);
		
		mav.setViewName(listPage);
		
		return mav;
	}
}