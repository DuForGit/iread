package com.iread.font.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iread.beans.domain.Book;
import com.iread.font.dao.BookMapper;
import com.iread.font.dao.SearchBooksMapper;
import com.iread.font.dao.SearchPublishMapper;
import com.iread.font.dao.SearchTypeMapper;
import com.iread.font.dao.SearchWriterMapper;
import com.iread.font.service.SearchService;
import com.iread.utils.PageUtil;

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
	@Autowired
	BookMapper bookMapper;
	
	/* (non-Javadoc)
	 * @see com.iread.font.service.SearchService#searchBooks(java.lang.String, java.lang.String)
	 */
	public /*List<Book>*/Map<String,Object> searchBooks(String type, String info,int page) {
		List<Integer> ids = new ArrayList<>();
		List<Book> bs;
		if(type.equals(TITLE)){
			PageUtil.startPage(page);
			bs = searchBooksMapper.getBooksByTitle(info);
			if(bs != null && !bs.isEmpty()){
				for(Book b : bs){
					ids.add(b.getId());
				}
				bookMapper.addSearch(ids);
			}
			
		}else{
			if(type.equals(TYPE)){
				PageUtil.startPage(page);
				ids = searchTypeMapper.getIdsByGeneralType(info);
				if(ids.isEmpty()){
					PageUtil.startPage(page);
					ids = searchTypeMapper.getIdsByGeneralClass(info);
				}
			}
			else if(type.equals(AUTHOR)){
			//System.out.println(searchWriterMapper.getWriterIds(info));
				/*Integer id = searchWriterMapper.getWriterId(info);
				if(id != null){
							searchBooksMapper.getBooksById(id);
				}*/
				PageUtil.startPage(page);
				ids = searchWriterMapper.getWriterIds(info);
			}
			else if(type.equals(PUBLISH)){
				PageUtil.startPage(page);
				ids = searchPublishMapper.getIdsByGeneralPublish(info);
			}else {
				ids = null;
			}
			//System.out.println("ids:" + ids.isEmpty());
			
			/*PageUtil.startPage(page);
			bs = !ids.isEmpty() || ids != null ?  searchBooksMapper.getBooksByIds(ids) : null;*/
			
			if(ids != null && !ids.isEmpty()){
				//PageUtil.startPage(page);
				bs = searchBooksMapper.getBooksByIds(ids);
				bookMapper.addSearch(ids);
				}else{
					bs = new ArrayList<>();}
		}
		return PageUtil.pageInfos(bs);
	}

}
