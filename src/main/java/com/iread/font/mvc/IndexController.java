package com.iread.font.mvc;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iread.font.service.BookService;
import com.iread.font.service.IndexService;
import com.iread.utils.SessionKey;

/**
 *项目名称: iread
 *类名称: IndexController
 *类描述: 首页index访问控制器,包含一些个性化内容推荐
 *创建人: Administrator
 *创建时间: 2017年11月30日下午9:20:49
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Controller
public class IndexController {
	@Autowired
	private IndexService index;
	@Autowired
	private BookService books;
	//index首页书籍推荐,热门、新书、个性化推荐
	@RequestMapping(value={"/index","/"},method=GET)
	public String index(HttpServletRequest request,Model model){
		int uid = 0;
		if(request.getSession().getAttribute(SessionKey.USER_ID) != null){
			uid = (int)request.getSession().getAttribute(SessionKey.USER_ID);
		}
		model.addAllAttributes(index.getIndexBooks(uid));
		model.addAttribute("actions", books.getBooksInAction());
		return "home";
	}
	

	
}
