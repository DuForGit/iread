package com.iread.font.service.impl;

import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iread.beans.domain.Book;
import com.iread.beans.domain.BookInAction;
import com.iread.beans.domain.Chaper;
import com.iread.font.dao.BookMapper;
import com.iread.font.dao.UserMapper;
import com.iread.font.service.BookService;

/**
 *项目名称: iread
 *类名称: BookServiceImpl
 *类描述: 
 * @author 方秋都
 *
 */
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private UserMapper userMapper;
	/*@Autowired
	private CommentMapper commentMapper;*/

	/* (non-Javadoc)
	 * @see com.iread.font.service.BookService#ebook(int, int)
	 */
	@Override
	public Map<String, Object> ebook(int uid, int bid) {
		
		Book book = bookMapper.getBookInfo(bid);
		
		if(book.getSoldout().after(new Date()) || bookMapper.isBuyBook(uid, bid) != null){
			Map<String, Object> infos = new HashMap<String, Object>();
			if(bookMapper.isExistBook(uid, bid) == null){
				infos.put("existbook", false);
			}else{infos.put("existbook", true);}
			if(bookMapper.isExistBookInMyCart(uid, bid) == null){
				infos.put("existcart", false);
			}else{infos.put("existcart", true);}
			if(userMapper.hasOrder(bid, uid) == null){
				infos.put("existorder", false);
			}else{
				infos.put("existorder", true);
			}
			infos.put("book", bookMapper.getBookInfo(bid));
			infos.put("chapter", bookMapper.getChaper(bid));
			return infos;
		}
		return null;
		
		
		/*Map<String, Object> infos = new HashMap<String, Object>();
		if(bookMapper.isExistBook(uid, bid) == null){
			infos.put("existbook", false);
		}else{infos.put("existbook", true);}
		if(bookMapper.isExistBookInMyCart(uid, bid) == null){
			infos.put("existcart", false);
		}else{infos.put("existcart", true);}
		infos.put("book", bookMapper.getBookInfo(bid));
		infos.put("chapter", bookMapper.getChaper(bid));
		//infos.put("comments", commentMapper.getComments(bid));
		return infos;*/
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.BookService#showtext(int, int)
	 */
	@Override
	public Map<String, Object> showtext(int uid, int bid) {
		Map<String, Object> infos = new HashMap<String, Object>();
		
		Integer exist = userMapper.isExistRecentReadingBook(uid, bid);
		if(exist == null){
			userMapper.InsertRecentReadingBook(uid, bid);
		}else{
			userMapper.changeReadingTime(exist);
		}
		
		if(bookMapper.isExistBook(uid, bid) == null){
			infos.put("buy", false);
		}else{
			Integer buy = bookMapper.isBuyBook(uid, bid);
			if(buy != null && buy > 0){
				infos.put("buy", true);
			}else{infos.put("buy", false);}
		}
		List<Chaper> cs = bookMapper.getChaper(bid);
		infos.put("chapter", cs);
		infos.put("text", bookMapper.getText(cs.get(0).getTeid()));
		infos.put("bookId",bid);
		infos.put("soldout", bookMapper.getSoldout(bid).after(new Date()));
		bookMapper.addReading(bid);
		return infos;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.BookService#text(int, int)
	 */
	@Override
	public Map<String, Object> text(int uid, int tid,int bid) {
		Map<String, Object> info = new HashMap<String, Object>();
		Integer buy = bookMapper.isBuyBook(uid, bid);
		System.out.println("是否购买：" + buy);
		
		
		if(buy != null && buy.intValue() > 0){
			info.put("text", bookMapper.getText(tid));
		}else{
			int p = bookMapper.getPages(bid);
			if(p > 0){
				Integer maxId = bookMapper.getMaxId(p-1, bid);
				if(maxId != null && maxId.intValue() > 0){
					if(maxId.intValue() >= tid){
						info.put("text", bookMapper.getText(tid));
					}else{
						info.put("text", null);
					}
				}
			}else{
				info.put("text", bookMapper.getText(tid));
			}
			
		}
		return info;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.BookService#ebook(int)
	 */
	@Override
	public Map<String, Object> ebook(int bid) {
		Book book = bookMapper.getBookInfo(bid);
		if(book.getSoldout().after(new Date())){
			Map<String, Object> infos = new HashMap<String, Object>();
			infos.put("existbook", false);
			infos.put("existcart", false);
			infos.put("existorder", false);
			infos.put("book", bookMapper.getBookInfo(bid));
			infos.put("chapter", bookMapper.getChaper(bid));
			//infos.put("comments", commentMapper.getComments(bid));
			return infos;
		}
		return null;
		/*Map<String, Object> infos = new HashMap<String, Object>();
		infos.put("existbook", false);
		infos.put("existcart", false);
		infos.put("book", bookMapper.getBookInfo(bid));
		infos.put("chapter", bookMapper.getChaper(bid));
		//infos.put("comments", commentMapper.getComments(bid));
		return infos;*/
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.BookService#showtext(int)
	 */
	@Override
	public Map<String, Object> showtext(int bid) {
		Map<String, Object> infos = new HashMap<String, Object>();
		infos.put("buy", false);
		List<Chaper> cs = bookMapper.getChaper(bid);
		infos.put("chapter", cs);
		infos.put("text", bookMapper.getText(cs.get(0).getTeid()));
		infos.put("bookId",bid);
		infos.put("soldout", bookMapper.getSoldout(bid).after(new Date()));
		
		return infos;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.BookService#text(int, int)
	 */
	@Override
	public Map<String, Object> text(int tid, int bid) {
		Map<String, Object> info = new HashMap<String, Object>();
		int p = bookMapper.getPages(bid);
		System.out.println("试读章节：" + p);
		if(p > 0){
			Integer maxId = bookMapper.getMaxId(p-1, bid);
			//System.out.println("所能获取的最大章节ID号：" + maxId + "; 本章获取的章节ID号：" + tid);
			if(maxId != null && maxId.intValue() >= 0){
				if(maxId.intValue() >= tid){
					info.put("text", bookMapper.getText(tid));
				}else{
					info.put("text", null);
				}
			}
		}else{
			info.put("text", bookMapper.getText(tid));
		}
		
		return info;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.BookService#getBooksInAction()
	 */
	@Override
	public List<BookInAction> getBooksInAction() {
		
		return bookMapper.getBookInAction();
	}

}
