package album.controller;

import java.text.ParseException;
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
public class AlbumUpdateController {
	
	private final String command = "/update.ab";	
	private final String formPage = "albumUpdateForm";
	private final String listPage = "redirect:/list.ab";
	
	@Autowired
	AlbumDao albumDao;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String updateForm(@RequestParam("num") int num, Model model) {
		AlbumBean album = albumDao.selectAlbumbyNum(num);
		model.addAttribute("album", album);
		
		return formPage;
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("album") @Valid AlbumBean album, BindingResult result) throws ParseException {
		ModelAndView mav = new ModelAndView();
		
		System.out.println("error: "+result.hasErrors());
		if(result.hasErrors()) {
			mav.setViewName(formPage);
		}
		else {
			int cnt = albumDao.updateAlbum(album);
			
			if(cnt>0) {
				System.out.println("Update 성공");
				mav.setViewName(listPage);
			}else {
				System.out.println("Update 실패");
				mav.setViewName(formPage);
			}
		}
		
		return mav;
	} 
	
}
