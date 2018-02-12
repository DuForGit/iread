package com.iread.font.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iread.font.dao.PublishsListMapper;
import com.iread.font.service.PublishListService;
import com.iread.utils.PageUtil;

/**
 *项目名称: iread
 *类名称: PublishListServiceImpl
 *类描述: 处理publish列表的具体实现
 *创建人: Administrator
 *创建时间: 2018年2月1日下午4:47:33
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Service
public class PublishListServiceImpl implements PublishListService {
	
	@Autowired
	private PublishsListMapper pm;

	/* (non-Javadoc)
	 * @see com.iread.font.service.PublishListService#getPublishs(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Map<String, Object> getPublishs(Integer order, Integer page) {
		
		PageUtil.startPage(page);
		return PageUtil.pageInfos(pm.getPublishs(order));
	}

}
