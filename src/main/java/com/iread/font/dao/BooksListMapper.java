package com.iread.font.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iread.beans.domain.Book;

/**
 *项目名称: iread
 *类名称: BooksListMap
 *类描述: 返回书籍的列表
 *创建人: Administrator
 *创建时间: 2018年1月8日上午10:47:32
 * @version 1.0.0
 * @author 方秋都
 *
 */
public interface BooksListMapper {
	//不支持重载，所以弃用
	//获取电子书的列表，不用提供任何条件
	//public List<Book> getBooks();
	
	//获取电子书的列表，根据类型ID获取
	//public List<Book> getBooksById(@Param("id") Integer id, @Param("ifclass") boolean ifClass);
	
	//根据类型ID、排列方式获取电子书的列表
	public List<Book> getBooksById(@Param("id") Integer id, @Param("ifclass") boolean ifClass, @Param("ord")Integer ord);
	
	//根据排列方式获取所有电子书的列表
	public List<Book> getBooks(@Param("ord")Integer ord);

}
