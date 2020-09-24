package album.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumDao;

@Controller
public class AlbumDeleteController {
	final String command = "delete.ab";
	final String getPage = "redirect:/list.ab";
	@Autowired
	private AlbumDao albumDao;
	
	@RequestMapping(command)
	public ModelAndView doAction(int num) {
		albumDao.delete(num); 
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(getPage);
		return mav;
	}
}
