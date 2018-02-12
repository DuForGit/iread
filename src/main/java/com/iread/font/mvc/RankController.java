package com.iread.font.mvc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iread.beans.domain.RankNav;
import com.iread.font.service.RankService;

/**
 *项目名称: iread
 *类名称: RankController
 *类描述: 榜单页面rank的处理控制器
 *创建人: Administrator
 *创建时间: 2018年2月2日上午12:15:22
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Controller
@RequestMapping("/rank")
public class RankController {
	
	@Autowired
	private RankService r;
	
	/**
	 * 
	 *方法名: rank
	 *描述: 处理books表单列表,0表示默认(畅销榜)、1表示新书榜、2表示热搜榜、3表示阅读榜、4表示评分榜、5表示推荐榜
	 * @param order
	 * @param page
	 * @return map 包含books列表的所有信息，包括分页栏等
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> rank(@RequestParam(value="ord", defaultValue="0",required=false)int order,
			@RequestParam(value="p",defaultValue="1",required=false) int page){
		if(order < 0 || order > 5){order = 0;}
		if(page < 1){page = 1;}
		return r.getRankBooks(order, page);
	}
	
	@RequestMapping(value="/nav")
	@ResponseBody
	public List<RankNav> rankNav(){
		return r.getRankNav();
	}
	
	@RequestMapping
	public String rank(){
		return "rank";
	}
	
}
