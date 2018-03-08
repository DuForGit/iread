package com.iread.font.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iread.beans.domain.Book;
import com.iread.font.dao.BooksListMapper;
import com.iread.font.dao.SearchBooksMapper;
import com.iread.font.dao.SearchPublishMapper;
import com.iread.font.service.BooksListService;
import com.iread.utils.PageUtil;

/**
 *项目名称: iread
 *类名称: BooksListServiceImpl
 *类描述: 关于BooksListService的实现
 *创建人: Administrator
 *创建时间: 2018年1月6日下午4:15:25
 * @version 1.0.0 
 * @author 方秋都
 *
 */
@Service
public class BooksListServiceImpl implements BooksListService {
	
	//每一页显示的book数量
	//private static final int PAGE_SIZE = 30;

	@Autowired
	private BooksListMapper books;
	

	/* (non-Javadoc)
	 * @see com.iread.font.service.BooksListService#getBooks()
	 */
	/*@Override
	public List<Book> Map<String, Object> getBooks() {
		//PageHelper.startPage(1, PAGE_SIZE);
		PageUtil.startPage(1);
		return PageUtil.pageInfos(books.getBooks(0));
	}*/

	/* (non-Javadoc)
	 * @see com.iread.font.service.BooksListService#getBooksById(java.lang.Integer)
	 */
	/*@Override
	public List<Book> Map<String, Object> getBooks(Integer id,boolean ifClass) {
		//PageHelper.startPage(1, PAGE_SIZE);
		PageUtil.startPage(1);
		return PageUtil.pageInfos(books.getBooksById(id, ifClass,0));
	}*/

	/* (non-Javadoc)
	 * @see com.iread.font.service.BooksListService#getBooks(java.lang.Integer, boolean, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Map<String, Object> getBooks(Integer id, boolean ifClass, Integer order, Integer page) {
		PageUtil.startPage(page);
		return PageUtil.pageInfos(books.getBooksById(id, ifClass, order));
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.BooksListService#getBooks(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Map<String, Object> getBooks(Integer order, Integer page) {
		PageUtil.startPage(page);
		return PageUtil.pageInfos(books.getBooks(order));
	}
	
	
	@Autowired
	private SearchBooksMapper searchBooksMapper;

	/* (non-Javadoc)
	 * @see com.iread.font.service.BooksListService#searchBooksOfPublish(java.lang.String, int)
	 */
	public Map<String, Object> searchBooksOfPublish(int id, int page) {
		
		List<Book> bs =  new ArrayList<>();
		//PageUtil.startPage(page);
		List<Integer> ids = books.getBookIdsOfPublish(id);
		if(ids != null && !ids.isEmpty()){
			PageUtil.startPage(page);
			bs = searchBooksMapper.getBooksByIds(ids);
		}
		return PageUtil.pageInfos(bs);
		
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.BooksListService#searchBooksOfWriter(int, int)
	 */
	@Override
	public Map<String, Object> searchBooksOfWriter(int id, int page) {
		List<Book> bs =  new ArrayList<>();
		List<Integer> ids = books.getBookIdsOfWriter(id);
		if(ids != null && !ids.isEmpty()){
			PageUtil.startPage(page);
			bs = searchBooksMapper.getBooksByIds(ids);
		}
		return PageUtil.pageInfos(bs);
	}
}
