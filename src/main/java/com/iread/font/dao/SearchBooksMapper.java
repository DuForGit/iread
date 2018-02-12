package com.iread.font.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.iread.beans.domain.Book;
import com.iread.beans.domain.Publish;
import com.iread.beans.domain.Type;
import com.iread.beans.domain.Writer;
import com.iread.font.service.SearchService;

/**
 *项目名称: iread
 *类名称: SearchBooksMapperImpl
 *类描述: 
 *创建人: Administrator
 *创建时间: 2017年11月16日下午11:38:48
 * @version
 * @author 方秋都
 *
 */

public interface SearchBooksMapper{
	
	public Book getBooksById(@Param("id")Integer id);
	public List<Book> getBooksByIds(@Param("ids")List<Integer> ids);
	public List<Book> getBooksByTitle(@Param("title")String title);
	public List<Book> getBooks(@Param("book")Book book);
	/*public List<Book> getBooksByWriter(@Param("writer")Writer writer);
	public List<Book> getBooksByPublish(@Param("publish")Publish publish);
	public List<Book> getBooksByType(@Param("type")Type type);
	public List<Book> getBooksByClass(@Param("clazz")Class clazz);*/
}
