package com.iread.font.service;

import java.util.Map;

/**
 *项目名称: iread
 *类名称: WriterListService
 *类描述: 处理writer列表的接口
 *创建人: Administrator
 *创建时间: 2018年1月30日下午4:16:03
 * @version 1.0.0
 * @author 方秋都
 *
 */
public interface WriterListService {
	/**
	 * 
	 *方法名: 
	 *描述: 
	 * @param page 页码
	 * @param order 排序（0表示默认(全部作家)，1表示推荐人数降序，2表示销量降序，3表示作品评分降序，4表示性别男，5表示性别女）
	 * @return Map<String, Object> 关于writer列表的全部信息（包含分页信息）
	 */
	
	Map<String, Object> getWriters(Integer page, Integer order);
}
