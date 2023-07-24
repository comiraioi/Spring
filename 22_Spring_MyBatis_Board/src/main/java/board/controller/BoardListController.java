package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardBean;
import board.model.BoardDao;
import utility.Paging;

@Controller
public class BoardListController {
	private final String command = "/list.bd";
	private String getPage = "boardList";	
	
	@Autowired
	BoardDao bdao;
	
	@RequestMapping(command)
	public String doAction(@RequestParam(value="whatColumn",required=false) String whatColumn,
						@RequestParam(value="keyword",required=false) String keyword,
						@RequestParam(value="pageNumber",required=false) String pageNumber,
						HttpServletRequest request, Model model) {
		
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		String pageSize = "5";
		int totalCount = bdao.getTotalCount(map);
		String url = request.getContextPath() + command;
		
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword, null);
		int beginRow = pageInfo.getBeginRow();
		int endRow = pageInfo.getEndRow();
		
		//map.put("beginRow", String.valueOf(beginRow));	//시작 행
		//map.put("endRow", String.valueOf(endRow));		//끝(5번째)행
		
		//int number = totalCount-(selPageNum-1)*5;	//글 나열 순서
		
		List<BoardBean> boardList = bdao.getBoardList(map, pageInfo);
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageInfo", pageInfo);
		
		return getPage;
	}
}
