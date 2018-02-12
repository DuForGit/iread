package com.iread.font.service;

import java.util.List;
import java.util.Map;


import com.iread.beans.domain.RankNav;

/**
 *项目名称: iread
 *类名称: RankService
 *类描述:  处理榜单页面的数据，包括菜单栏、书列表、分页栏等
 *创建人: Administrator
 *创建时间: 2018年2月2日上午11:29:36
 * @version 1.0.0
 * @author 方秋都
 *
 */

public interface RankService {
	
	//菜单栏
	List<RankNav> getRankNav();
	/**
	 * 
	 *方法名: getRankBooks
	 *描述: 获取books列表，order表示列表所属的类型（榜单）、page表示页码
	 * @param order
	 * @param page
	 * @return map 包含books列表、分页
	 */
	Map<String, Object> getRankBooks(int order, int page);
}
