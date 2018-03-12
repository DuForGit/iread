package com.iread.font.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iread.beans.domain.Book;
import com.iread.font.dao.IndexMapper;
import com.iread.font.dao.UserMapper;
import com.iread.font.service.IndexService;

/**
 *项目名称: iread
 *类名称: IndexServiceImpl
 *类描述: indexService的具体实现
 * @author 方秋都
 *
 */
@Service
public class IndexServiceImpl implements IndexService{

	/* (non-Javadoc)
	 * @see com.iread.font.service.IndexService#getNewBooks()
	 */
	@Override
	public List<Book> getNewBooks() {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.IndexService#getHotBooks()
	 */
	@Override
	public List<Book> getHotBooks() {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.IndexService#getHotSaleBooks()
	 */
	@Override
	public List<Book> getHotSaleBooks() {
		
		return null;
	}

	@Autowired
	IndexMapper indexMapper;
	@Autowired
	UserMapper userMapper;
	
	/* (non-Javadoc)
	 * @see com.iread.font.service.IndexService#getIndexBooks()
	 */
	@Override
	public Map<String, Object> getIndexBooks() {
		Map<String, Object> index =  new HashMap<>();
		index.put("hots", indexMapper.getHotBooks());
		index.put("news", indexMapper.getNewBooks());
		index.put("sales", indexMapper.getHotSaleBooks());
		return index;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.IndexService#getIndexBooks(int)
	 */
	@Override
	public Map<String, Object> getIndexBooks(int uid) {
		Map<String, Object> index = getIndexBooks();
		List<Integer> bids = userMapper.getBookIdsByUserId(uid);
		if(bids !=null && !bids.isEmpty()){
			index.put("bookcase", userMapper.getBooksByTypeIds(userMapper.getTypeIdsByBooksId(bids), bids));
		}
		bids = userMapper.getMyCartBookIds(uid);
		if(bids !=null && !bids.isEmpty()){
			index.put("cartbook", userMapper.getBooksByTypeIds(userMapper.getTypeIdsByBooksId(bids), bids));
		}
		bids = userMapper.getMyOrderBookIds(uid);
		if(bids !=null && !bids.isEmpty()){
			index.put("orderbook", userMapper.getBooksByTypeIds(userMapper.getTypeIdsByBooksId(bids), bids));
		}
		
		return index;
	}

	

}
