package com.iread.font.service;

import java.util.List;
import java.util.Map;

import com.iread.beans.domain.Book;

/**
 *项目名称: iread
 *类名称: IndexService
 *类描述: 首页模块的业务处理
 * @author 方秋都
 *
 */
public interface IndexService {
	//获取新的书籍
	List<Book> getNewBooks();
	//获取热门书籍
	List<Book> getHotBooks();
	//获取热买书籍
	List<Book> getHotSaleBooks();
	
	//获取用户阅读的类型推荐
	/*Map<String,Object> getIndividuationBooks(int uid);*/
	
	//获取首页书籍
	Map<String, Object> getIndexBooks(int id);
	Map<String, Object> getIndexBooks();
	

}
