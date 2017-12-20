package com.iread.font.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iread.beans.domain.Book;
import com.iread.font.dao.SearchBooksMapper;
import com.iread.font.dao.SearchPublishMapper;
import com.iread.font.dao.SearchTypeMapper;
import com.iread.font.dao.SearchWriterMapper;
import com.iread.font.service.SearchService;

/**
 *项目名称: iread
 *类名称: SearchServiceImpl
 *类描述: 
 *创建人: Administrator
 *创建时间: 2017年11月17日下午3:18:30
 * @version
 * @author 方秋都
 *
 */
@Service
public class SearchServiceImpl implements SearchService {

	private final String TITLE = "书名";
	private final String TYPE = "类型";
	private final String AUTHOR = "作者";
	private final String PUBLISH = "出版社";
	
	@Autowired
	private SearchBooksMapper searchBooksMapper;
	
	@Autowired
	private SearchWriterMapper searchWriterMapper;
	
	@Autowired
	private SearchTypeMapper searchTypeMapper;
	
	@Autowired
	private SearchPublishMapper searchPublishMapper;
	
	
	/* (non-Javadoc)
	 * @see com.iread.font.service.SearchService#searchBooks(java.lang.String, java.lang.String)
	 */
	public List<Book> searchBooks(String type, String info) {
		List<Integer> ids;
		if(type == TITLE){
			return searchBooksMapper.getBooksByTitle(info);
		}
		else if(type == TYPE){
			ids = searchTypeMapper.getIdsByGeneralType(info);
		}
		else if(type == AUTHOR){
			ids = searchWriterMapper.getWriterIds(info);
		}
		else if(type == PUBLISH){
			ids = searchPublishMapper.getIdsByGeneralPublish(info);
		}else {
			return null;
			}
		return ids.isEmpty()!=true ? searchBooksMapper.getBooksByIds(ids) : null;
	}

}
