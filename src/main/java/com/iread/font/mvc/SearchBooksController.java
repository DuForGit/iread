package com.iread.font.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;
import java.util.Map;

import com.iread.beans.domain.Book;
import com.iread.font.beans.vo.SearchVo;
import com.iread.font.service.SearchService;

/**
 *项目名称: iread
 *类名称: SearchBooksController
 *类描述: 
 *创建人: Administrator
 *创建时间: 2017年11月21日下午6:20:03
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Controller
public class SearchBooksController {
	
	@Autowired
	private SearchService searchService;
	
	@RequestMapping(value="/search",method = POST)
	@ResponseBody
	public /*List<Book>*/ Map<String,Object> searchBooks(SearchVo search){
		System.out.println(search.getTypes());
		System.out.println(search.getInfo());
		System.out.println(search.getPage());
		return searchService.searchBooks(search.getTypes(), search.getInfo(), search.getPage());
		}
}  
