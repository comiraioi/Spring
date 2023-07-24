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
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumInsertController {
	
	private final String command = "/insert.ab";	
	private final String insertFormPage = "albumInsertForm";
	private final String listPage = "redirect:/list.ab";
	
	@Autowired
	AlbumDao albumDao;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public ModelAndView insertForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(insertFormPage);
		
		return mav;
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("album") @Valid AlbumBean album, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		System.out.println("error: "+result.hasErrors());
		if(result.hasErrors()) {
			mav.setViewName(insertFormPage);
		}
		else {
			int cnt = albumDao.insertAlbum(album);
			
			if(cnt>0) {
				System.out.println("Insert 성공");
				mav.setViewName(listPage);
			}else {
				System.out.println("Insert 실패");
				mav.setViewName(insertFormPage);
			}
		}
		
		return mav;
	}
	
}
