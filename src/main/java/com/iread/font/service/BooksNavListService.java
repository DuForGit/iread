package com.iread.font.service;

import java.util.List;

/**
 *项目名称: iread
 *类名称: BooksNavListService
 *类描述: books分类页面的菜单栏接口
 *创建人: Administrator
 *创建时间: 2018年1月7日下午2:33:04
 * @version 1.0.0
 * @author 方秋都
 *
 */
public interface BooksNavListService {
	//返回菜单栏信息
	List<com.iread.beans.domain.Class> getBookNavs();
}
