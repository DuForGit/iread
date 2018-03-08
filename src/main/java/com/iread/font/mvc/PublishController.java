package com.iread.font.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iread.font.service.BooksListService;
import com.iread.font.service.PublishListService;

/**
 *项目名称: iread
 *类名称: PublishController
 *类描述: 出版社模块的处理
 *创建人: Administrator
 *创建时间: 2018年2月1日下午3:57:46
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Controller
@RequestMapping(value="/publishs")
public class PublishController {
	
	@Autowired
	private PublishListService ps;
	@Autowired
	private BooksListService books;
	
	/**
	 * 
	 *方法名: publishs
	 *描述: 返回publish列表的所有信息，包含列表，分页栏等
	 * @param order 排序，默认为0；0表示所有，1表示按推荐人数从多向少排列，2表示按出版社总书籍销量从多向少排序，3表示出版社主页访问量从多向少排序，4表示按出版社总书籍阅读量从多向少排序
	 * @param page 页码，默认为1；
	 * @return Map 包含publish所有信息的map
	 */
	@RequestMapping(value="/list")
	@ResponseBody
	public Map<String,Object> publishs(@RequestParam(value="ord",defaultValue="0",required=false) int order,
			@RequestParam(value="p",defaultValue="1",required=false) int page){
		if(order >4 || order < 0){
			order =0;
		}
		if(page < 1){
			page = 1;
		}
		return ps.getPublishs(order, page);
	}
	
	@RequestMapping
	public String publishs(){
		return "publish";
	}
	
	@RequestMapping("/bookofpub")
	public String bookOfPublish(int id,Model model){
		model.addAttribute("id", id);
		return "bookofpublish";
	}
	@RequestMapping(value="/bookofpublish",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> bookOfPublish(int id,int page){
		return books.searchBooksOfPublish(id, page);
	}
	
	
}
