package com.iread.font.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iread.beans.domain.Book;
import com.iread.beans.domain.Publish;
import com.iread.beans.domain.Type;
import com.iread.beans.domain.Writer;
import com.iread.font.dao.SearchBooksMapper;

/**
 *项目名称: iread
 *类名称: SearchService
 *类描述: 搜索框的功能实现接口
 *创建人: 方秋都
 *创建时间: 2017年11月16日下午11:20:52
 * @version 1.0.0
 * @author 方秋都
 *
 */
public interface SearchService {
	
	/**
	 * 搜索框的实现方法，根据搜索框的下拉列表和输入内容搜索电子书
	 * @param type 下拉列表类型
	 * @param info 输入内容
	 * @return 电子书的集合
	 */
	List<Book> searchBooks(String type,String info);
	
}
