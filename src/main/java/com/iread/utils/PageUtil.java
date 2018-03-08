package com.iread.utils;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 *项目名称: iread
 *类名称: PageUtil
 *类描述: 分页处理工具类，利用pagehelper插件
 *创建人: Administrator
 *创建时间: 2018年1月13日下午6:29:09
 * @version 1.0.0 
 * @author 方秋都
 *
 */
public class PageUtil {
	private static final int PAGE_SIZE = 1;//默认每一页的book数量
	private PageUtil(){}
	public static final PageUtil PAGE_UTIL = new PageUtil();
	
	//分页处理
	public static void startPage(int pageNum){
		PageHelper.startPage(pageNum, PAGE_SIZE);
	}
	
	//分页信息
	public static <T> Map<String, Object> pageInfos(List<T> list){
		
		Map<String, Object> jsonData = null;
		if(list != null){
			PageInfo<T> page = new PageInfo<T>(list);
			long total = page.getTotal();//查询总的book数量
			int pageNum = page.getPageNum();//当前页码
			int pages =page.getPages();//总页数
			int pre = page.getPrePage();//前一页
			int next = page.getNextPage();//下一页
			boolean isFirstPage = page.isIsFirstPage();//是否为第一页
			boolean isLastPage = page.isIsLastPage();//是否为最后一页
			boolean hasPreviousPage = page.isHasPreviousPage();//是否有前一页
			boolean hasNextPage = page.isHasNextPage();//是否有后一页
			jsonData = new HashMap<>();
			jsonData.put("list", list);
			jsonData.put("total", total);
			jsonData.put("pageNum", pageNum);
			jsonData.put("pages", pages);
			jsonData.put("pre", pre);
			jsonData.put("next", next);
			jsonData.put("isFirstPage", isFirstPage);
			jsonData.put("isLastPage", isLastPage);
			jsonData.put("hasPreviousPage", hasPreviousPage);
			jsonData.put("hasNextPage", hasNextPage);
		}
		return jsonData;
	}
}
