package com.iread.font.service;

import java.util.List;
import java.util.Map;

import com.iread.beans.domain.Book;

/**
 *项目名称: iread
 *类名称: BooksListService
 *类描述: 关于books列表的处理
 *创建人: Administrator
 *创建时间: 2018年1月5日下午10:21:36
 * @version 1.0.0
 * @author 方秋都
 *
 */
public interface BooksListService {
	
	//无条件查询所有书籍，即无条件（排序方式、分页、类型）返回所有书籍,但返回的是第一页的数据
	//弃用
	/*List<Book> Map<String, Object> getBooks();*/
	
	//弃用
	/*List<Book> Map<String, Object> getBooks(Integer id,boolean ifClass);*/
	
	//根据类型ID、排序方法、页数查找books列表
	/*List<Book>*/Map<String, Object> getBooks(Integer id, boolean ifClass, Integer order, Integer page);
	
	//根据排序方式、页数返回所有类型的结果
	/*List<Book>*/Map<String, Object> getBooks(Integer order, Integer page);
	
	
/**	//根据类型ID和Book表中ID(主键)的数值（该值用于控制查询的开始位置，用于分页）
	List<Book> getBooksByIdAndPage(Integer id, Integer bookId);
	
	//根据阅读的热度来返回数据
	List<Book> getBooksByReadNums(Integer num);
	
	//根据类型的ID和阅读的热度来返回数据
	List<Book> getBooksByIdAndReadNums(Integer id, Integer num);
	
	//根据类型的ID和阅读的热度来返回数据,还用到分页
	List<Book> getBooksByIdAndReadNums(Integer id, Integer num, Integer limit);
	
	//返回最新的books,实际就是更加主键的ID来判断
	List<Book> getBooksByNewBooks(Integer id);
		
	//根据类型的ID和book的ID来返回最新的books
	List<Book> getBooksByIdAndNewBook(Integer id, Integer bookId);
	
	//根据类型的ID和book的ID来返回最新的books,还用到分页
	List<Book> getBooksByIdAndNewBook(Integer id, Integer bookId, Integer limit);
	
	//根据销量返回books
	List<Book> getBooksBySales(Integer id);
			
	//根据类型的ID和book的销量来返回books
	List<Book> getBooksByIdAndSales(Integer id, Integer num);
	
	//根据类型的ID和book的销量来返回books,用到分页
	List<Book> getBooksByIdAndSales(Integer id, Integer num, Integer limit);
	
	//根据价格返回books
	List<Book> getBooksByPrice(Integer id);
				
	//根据类型的ID和book的价格来返回books
	List<Book> getBooksByIdAndPrice(Integer id, Float price);
	
	//根据类型的ID和book的价格来返回books，用到分页
	List<Book> getBooksByIdAndPrice(Integer id, Float price, Integer limit);*/
	
}
