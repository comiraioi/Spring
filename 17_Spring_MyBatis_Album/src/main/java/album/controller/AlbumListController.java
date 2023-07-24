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
	
	private final String command = "/list.ab";	//���
	private final String getPage = "albumList";
	
	@Autowired	/* ��ü �ڵ� ���� */
	AlbumDao albumDao;
	
	/* [list.ab ��û�ϴ� ���]
	   - start.jsp �����ϸ� GET��� ��û
	   - list.jsp���� �˻� Ŭ���ϸ� GET��� ��û => whatColumn(select��), keyword(input��) �Ѿ�� 
	   - list.jsp���� ��������ȣ Ŭ���ϸ� GET��� ��û => pageNumber(����ڰ� ������ ��������ȣ) �Ѿ�� */
	@RequestMapping(value=command)	
	public ModelAndView doAction(Model model, HttpServletRequest request, 
			//required = false => �ݵ�� �Ѿ���� ���� �ƴ�
			@RequestParam(value="whatColumn", required = false) String whatColumn, 
			@RequestParam(value="keyword", required = false) String keyword,
			@RequestParam(value="pageNumber", required = false) String pageNumber) {
		
		/* �Ӽ� ���� -> jsp�� ��������
		//���1: model
		model.addAttribute("albumLists", albumLists);
		//���2: request
		request.setAttribute("albumLists", albumLists); */
		//���3: ModelAndView
		ModelAndView mav = new ModelAndView();
		
		System.out.println("whatColumn: "+whatColumn);
		System.out.println("keyword: "+keyword);
		System.out.println("pageNumber: "+pageNumber);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn",whatColumn);
		map.put("keyword","%"+keyword+"%");
		
		//��ü ���� or �˻���� ����
		int totalCount = albumDao.getTotalCount(map);
		System.out.println("totalCount: "+totalCount);
		
		//url: �⺻ ��ġ(com.spring.ex => ex) + ��û�� 
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
