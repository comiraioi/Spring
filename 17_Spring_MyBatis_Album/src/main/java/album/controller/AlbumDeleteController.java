package album.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumDeleteController {
	
	private final String command = "/delete.ab";	
	private final String listPage = "redirect:/list.ab";
	
	@Autowired
	AlbumDao albumDao;
	
	@RequestMapping(command)
	public String delete(@RequestParam("num") int num) {	//���2
		/* num �ޱ� 
		//���1 
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("������ num: "+num); */
		
		int cnt = albumDao.deleteAlbum(num);
		if(cnt>0) {
			System.out.println("Delete ����");
		}else {
			System.out.println("Delete ����");
		}
		
		return listPage;
	}
	
}
