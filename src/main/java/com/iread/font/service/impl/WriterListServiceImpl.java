package com.iread.font.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iread.font.dao.WritersListMapper;
import com.iread.font.service.WriterListService;
import com.iread.utils.PageUtil;

/**
 *项目名称: iread
 *类名称: WriterListServiceImpl
 *类描述: 处理writer列表的具体实现
 *创建人: Administrator
 *创建时间: 2018年1月30日下午4:41:37
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Service
public class WriterListServiceImpl implements WriterListService {
	
	@Autowired
	private WritersListMapper writers;

	/* (non-Javadoc)
	 * @see com.iread.font.service.WriterListService#getWriters(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Map<String, Object> getWriters(Integer page, Integer order) {
		PageUtil.startPage(page);
		return PageUtil.pageInfos(writers.getWriters(order));
	}

}
