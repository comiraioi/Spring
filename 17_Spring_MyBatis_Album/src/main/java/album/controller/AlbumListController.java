package album.controller;

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

import album.model.AlbumBean;
import album.model.AlbumDao;
import utility.Paging;

@Controller
public class AlbumListController {
	
	private final String command = "/list.ab";	//상수
	private final String getPage = "albumList";
	
	@Autowired	/* 객체 자동 주입 */
	AlbumDao albumDao;
	
	/* [list.ab 요청하는 경우]
	   - start.jsp 실행하면 GET방식 요청
	   - list.jsp에서 검색 클릭하면 GET방식 요청 => whatColumn(select값), keyword(input값) 넘어옴 
	   - list.jsp에서 페이지번호 클릭하면 GET방식 요청 => pageNumber(사용자가 선택한 페이지번호) 넘어옴 */
	@RequestMapping(value=command)	
	public ModelAndView doAction(Model model, HttpServletRequest request, 
			//required = false => 반드시 넘어오는 것은 아님
			@RequestParam(value="whatColumn", required = false) String whatColumn, 
			@RequestParam(value="keyword", required = false) String keyword,
			@RequestParam(value="pageNumber", required = false) String pageNumber) {
		
		/* 속성 설정 -> jsp로 가져가기
		//방법1: model
		model.addAttribute("albumLists", albumLists);
		//방법2: request
		request.setAttribute("albumLists", albumLists); */
		//방법3: ModelAndView
		ModelAndView mav = new ModelAndView();
		
		System.out.println("whatColumn: "+whatColumn);
		System.out.println("keyword: "+keyword);
		System.out.println("pageNumber: "+pageNumber);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn",whatColumn);
		map.put("keyword","%"+keyword+"%");
		
		//전체 갯수 or 검색결과 갯수
		int totalCount = albumDao.getTotalCount(map);
		System.out.println("totalCount: "+totalCount);
		
		//url: 기본 위치(com.spring.ex => ex) + 요청명 
		String url = request.getContextPath()+command;
		System.out.println("url: "+url);	//url: /ex/list.ab
		
		Paging pageInfo = new Paging(pageNumber,"3",totalCount,url,whatColumn,keyword,null);
		
		List<AlbumBean> albumLists = albumDao.getAlbumList(map,pageInfo);
		mav.addObject("albumLists", albumLists);
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("totalCount",totalCount);
		mav.setViewName(getPage);
		
		return mav;
	}
	
}
