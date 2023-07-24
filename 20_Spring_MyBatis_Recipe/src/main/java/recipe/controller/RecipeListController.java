package recipe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import recipe.model.RecipeBean;
import recipe.model.RecipeDao;
import utility.Paging;

@Controller
public class RecipeListController {
	private final String command = "/list.rc";
	private String listPage = "recipeList";
	
	@Autowired
	RecipeDao rdao;
	
	@RequestMapping(value=command)
	public ModelAndView list(@RequestParam(value="col",required=false) String col,
					@RequestParam(value="keyword",required=false) String keyword,
					@RequestParam(value="pageNumber",required=false) String pageNumber, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("col", col);
		map.put("keyword", "%"+keyword+"%");
		
		String pageSize="3";
		int totalCount = rdao.getTotalCount(map);
		String url = request.getContextPath() + command;
		
		/* Paging ��ü �����ڷ� �� ����
		   - pageNumber: ����ڰ� ������ ��������ȣ, pageSize: �� �������� ������ ���ڵ� ����
		   - totalCount: ��ü ���ڵ� ���� or �˻���� ����,
		   - url: �⺻��ġ+��û��, col: �˻��� �÷�, keyword: �˻� Ű���� */
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, col, keyword, null);
		
		List<RecipeBean> lists = rdao.getAllRecipe(map, pageInfo);
		mav.addObject("lists", lists);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(listPage);
		
		return mav;
	}
	
}
