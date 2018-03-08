package com.iread.font.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iread.beans.domain.AIIAboutMe;
import com.iread.beans.domain.Book;
import com.iread.beans.domain.MyBookDo;
import com.iread.beans.domain.Order;
import com.iread.beans.domain.UserInfomations;
import com.iread.font.dao.BooksListMapper;
import com.iread.font.dao.UserMapper;
import com.iread.font.service.UserService;
import com.iread.utils.PageUtil;

/**
 *项目名称: iread
 *类名称: UserServiceImpl
 *类描述: UserService的具体实现
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper user;
	@Autowired
	private BooksListMapper books;

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#getMyBooks(int)
	 */
	@Override
	public Map<String, Object> getMyBooks(int userId,int page) {
		List<Book> bs = null;
		List<Integer> bookIds = user.getBookIdsByUserId(userId);
		if(bookIds != null && !bookIds.isEmpty()){
			//PageUtil.startPage(page);
			bs = books.getBookByIds(bookIds);
		}
		if(bs != null && !bs.isEmpty()){
			return PageUtil.pageInfos(bs);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#getMyCarts(int)
	 */
	@Override
	public Map<String, Object> getMyCarts(int userId,int page) {
		//PageUtil.startPage(page);
		List<Integer> ids = user.BookIdsOfMyCart(userId);
		
		List<Book> bs = null;
		if(ids != null && !ids.isEmpty()){
			//PageUtil.startPage(page);
			bs = user.getMyCart(ids);
		}
		if(bs != null && !bs.isEmpty()){
			return PageUtil.pageInfos(bs);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#getMyOrders(int)
	 */
	@Override
	public List<Order> getMyOrders(int userId) {
		System.out.println(user.getOrderBookIdsByUserId(userId));
		return user.getOrderBookIdsByUserId(userId);
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#getnews(int)
	 */
	@Override
	public Map<String, Object> getnews(int userId) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#getMyInfos(int)
	 */
	@Override
	public AIIAboutMe getMyInfos(int userId) {
		AIIAboutMe all = new AIIAboutMe();
		all.setUser(user.getMyAllInfos(userId));
		all.setBooks(user.getRecentReadingBooks(userId));
		return all;
	}

	@Override
	public void setMyInfos(UserInfomations info) {
		user.setMyInfos(info);
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#changeMyInfos(com.iread.beans.domain.UserInfomations)
	 */
	@Override
	public void changeMyInfos(UserInfomations info) {
		if(user.isExistInfo(info.getId()) != 0){
			user.changeMyInfos(info);
		}else{
			user.setMyInfos(info);
		}
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#changePass(int, java.lang.String)
	 */
	@Override
	public boolean changePass(int userId, String newPass) {
		Integer success = user.resetPassword(newPass, userId);
		if(success != null){
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#addMyBook(com.iread.beans.domain.MyBookDo)
	 */
	@Override
	public void addMyBook(MyBookDo book) {
		user.addMyBook(book);
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#deleteMyBook(int)
	 */
	@Override
	public void deleteMyBook(int id) {
		user.deleteMyBook(id);
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#addBookToMyCart(int, int)
	 */
	@Override
	public boolean addBookToMyCart(int bookId,int userId) {
		if(user.numOfMyCart(userId) > 99){
			return false;
		}
		
		if(user.addBookToMyCart(userId, bookId) == 0)return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#moveBookFromMyCart(int)
	 */
	@Override
	public void moveBookFromMyCart(int uid , int bid) {
		
		user.deleteMyCart(user.getCartId(uid, bid));
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#getMybookId(int, int)
	 */
	@Override
	public int getMybookId(int uId, int bId) {
		return user.getMybookId(uId, bId);
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#buyBook(int)
	 */
	@Override
	public void buyBook(int bid,int uid) {
		Integer buy = user.isBuyBook(bid, uid);
		if(buy == null){
			user.addBook(bid, uid);
		}else{
			if(buy.intValue() == 0){
				user.buyBook(bid, uid);
			}
		}
		//user.deleteCartBook(bid, uid);
		
		user.addOrder(bid, uid, user.getPrice(bid));
		user.addOne(bid);

	}

}
