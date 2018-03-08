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
import com.iread.font.service.WriterListService;

/**
 *项目名称: iread
 *类名称: WriterController
 *类描述: 作家模块实现（作家列表、作家作品、简介等）
 *创建人: Administrator
 *创建时间: 2018年1月19日下午1:10:31
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Controller
@RequestMapping(value="/writers")
public class WriterController {
	
	@Autowired
	private WriterListService writers;
	
	@RequestMapping(value="/list")
	@ResponseBody
	public Map<String,Object> writers(@RequestParam(value="ord",defaultValue = "0", required=false) int order,
			@RequestParam(value="p",defaultValue = "1",required=false) int page){
		//参数合理化
			if(order > 5 || order<0){
				order = 0;
			}
			if(page<=0){
				page = 1;
			}
		return writers.getWriters(page, order);
	}
	
	@RequestMapping
	public String writers(){
		return "writer";
	}
	
	
	@RequestMapping("/bookofwri")
	public String bookOfPublish(int id,Model model){
		model.addAttribute("id", id);
		return "bookofwriter";
	}
	@Autowired
	private BooksListService books;
	
	@RequestMapping(value="/bookofwriter",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> bookOfPublish(int id,int page){
		System.out.println("writerId:" + id);
		return books.searchBooksOfWriter(id, page);
	}
	
	
}
