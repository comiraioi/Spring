package movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import movie.model.MovieBean;
import movie.model.MovieDao;
import utility.Paging;

@Controller
public class MoiveListController {
	
	private final String command = "/list.mv";
	private String listPage = "movieList";
	
	@Autowired
	MovieDao mdao;
	
	@RequestMapping(value=command)
	public ModelAndView list(@RequestParam(value="col",required=false) String col,
							@RequestParam(value="keyword",required=false) String keyword,
							@RequestParam(value="pageNumber",required=false) String pageNumber,
							HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("col", col);
		map.put("keyword", "%"+keyword+"%");
		
		String pageSize="2";
		int totalCount = mdao.getTotalCount(map);
		String url = request.getContextPath() + command;
		
		/* Paging ��ü �����ڷ� �� ����
		   - pageNumber: ����ڰ� ������ ��������ȣ, pageSize: �� �������� ������ ���ڵ� ����
		   - totalCount: ��ü ���ڵ� ���� or �˻���� ����,
		   - url: �⺻��ġ+��û��, col: �˻��� �÷�, keyword: �˻� Ű���� */
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, col, keyword, null);
		
		List<MovieBean> lists = mdao.getAllMovie(map,pageInfo);
		mav.addObject("lists", lists);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(listPage);
		
		return mav;
	}
	
}
