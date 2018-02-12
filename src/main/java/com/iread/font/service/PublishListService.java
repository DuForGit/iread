package com.iread.font.service;

import java.util.Map;

/**
 *项目名称: iread
 *类名称: PublishListService
 *类描述: 处理publish列表的接口
 *创建人: Administrator
 *创建时间: 2018年2月1日下午4:24:06
 * @version 1.0.0
 * @author 方秋都
 *
 */
public interface PublishListService {
	Map<String,Object> getPublishs(Integer order,Integer page);
}
