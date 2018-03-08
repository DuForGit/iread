package com.iread.font.mvc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iread.font.service.BookService;
import com.iread.utils.SessionKey;

/**
 *项目名称: iread
 *类名称: BookController
 *类描述: 
 * @author 方秋都
 *
 */
@Controller
public class BookController {
	@Autowired
	private BookService book;
	
	@RequestMapping("ebook")
	public String ebook(HttpServletRequest request ,@RequestParam(value="id",required=true) int id,Model model){
		Map<String, Object> infos;
		if(request.getSession().getAttribute(SessionKey.USER_ID) == null){
			infos = book.ebook(id);
		}else{
			int uid = (int) request.getSession().getAttribute(SessionKey.USER_ID);
			infos = book.ebook(uid, id);
		}
		model.addAttribute("infos",infos);
		return "ebook";
	}
	
	@RequestMapping("showtext")
	public String showText(@RequestParam(value="bid",required=true)int bid,
			/*@RequestParam(value="tid",required=true)int tid,*/HttpServletRequest request,Model model){
		Map<String, Object> infos;
		if(request.getSession().getAttribute(SessionKey.USER_ID) == null){
			infos = book.showtext(bid);
		}else{
			int uid = (int)request.getSession().getAttribute(SessionKey.USER_ID);
			infos = book.showtext(uid, bid);
		}
		model.addAttribute("infos",infos);
		return "show";
	}
	
	@RequestMapping(value="text")
	public String bookText(HttpServletRequest request,int tid,int bid,Model model){
		Map<String, Object> infos;
		if(request.getSession().getAttribute(SessionKey.USER_ID) == null){
			infos = book.text(tid, bid);
		}else{
			int uid = (int)request.getSession().getAttribute(SessionKey.USER_ID);
			infos = book.text(uid, tid, bid);
		}
		model.addAttribute("info",infos);
		return "text";
	}

}
