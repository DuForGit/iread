package com.iread.font.dao;

import java.util.List;

/**
 *项目名称: iread
 *类名称: BooksNavMapper
 *类描述: 关于分类页面的菜单列表的处理，如：返回一个关于类型的列表
 *创建人: Administrator
 *创建时间: 2018年1月6日下午4:31:21
 * @version 1.0.0
 * @author 方秋都
 *
 */
public interface BooksNavMapper {
	//返回books页面的菜单栏
	public List<com.iread.beans.domain.Class> booksNavList();
}
