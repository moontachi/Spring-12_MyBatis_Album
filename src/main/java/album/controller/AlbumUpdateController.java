package album.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumUpdateController {
	
	final String command = "update.ab";
	final String gotoPage = "redirect:/list.ab";
	final String getPage = "AlbumUpdateForm";
	@Autowired
	//@Qualifier("myAlbumDao")
	private AlbumDao albumDao;
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public ModelAndView doAction(HttpServletRequest request) {
		int num =Integer.parseInt(request.getParameter("num"));
		System.out.println("AUC Num : "+num);
		AlbumBean ab = albumDao.selectAlbum(num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("ab", ab);
		mav.setViewName(getPage);
		return mav;
	}
	
	@RequestMapping(value=command,method = RequestMethod.POST)
	public ModelAndView doAction( @ModelAttribute("ab") @Valid AlbumBean ab,BindingResult result) {
		System.out.println(ab.getNum());
		System.out.println(ab.getTitle());
		System.out.println(ab.getSinger());
		System.out.println(ab.getPrice());
		System.out.println(ab.getDay());
		
		ModelAndView mav = new ModelAndView();
		
		
		if(result.hasErrors()) {
			System.out.println("유효성 검사 오류 발생");
			mav.setViewName(getPage);
			return mav;
		}
		int cnt = albumDao.updateAlbum(ab);
		System.out.println("AUC cnt : " +cnt );
		
		mav.setViewName(gotoPage);
		return mav;
	}
	
	
	
	
}
