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
public class AlbumDetailController {
	
	private final String command = "/detail.ab";
	private final String detailPage = "albumDetailView";
	
	@Autowired
	AlbumDao albumDao;
	
	@RequestMapping(command)
	public String detail(@RequestParam("num") int num, Model model) {
		
		AlbumBean album = albumDao.selectAlbumbyNum(num);
		model.addAttribute("album", album);
		
		return detailPage;
	}
	
}
