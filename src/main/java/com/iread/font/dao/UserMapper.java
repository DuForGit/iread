package com.iread.font.dao;

import java.util.List;


import org.apache.ibatis.annotations.Param;

import com.iread.beans.domain.Book;
import com.iread.beans.domain.MyBookDo;
import com.iread.beans.domain.Order;
import com.iread.beans.domain.RecentReadingBook;
import com.iread.beans.domain.User;
import com.iread.beans.domain.UserInfomations;



/**
 *项目名称: iread
 *类名称: UserMapper
 *类描述: 关于用户的一系列操作
 *
 */
public interface UserMapper {
	//注册功能
	
	public Integer getUserByName(@Param("name")String name, @Param("pass")String pass);
	public Integer getUserByEmail(@Param("email")String email, @Param("pass")String pass);
	
	//验证功能
	
	public Integer isExistEmail(@Param("email") String name);
	public Integer isExistName(@Param("name") String name);
	
	//判斷info表中是否存在数据
	public int isExistInfo(@Param("id") int id);
	
	//用户功能操作
	
	//根据用户ID获取book ID列表(mybooks)
	public List<Integer> getBookIdsByUserId(@Param("id") int id);
	public int getMybookId(@Param("uid")int uId,@Param("bid")int bId);//根据用户ID和图书ID找书架对应的主键
	
	
	
	//获取订单信息(order)
	public List<Order> getOrderBookIdsByUserId(@Param("id") int id);
	
	//重置密码(user)
	public Integer resetPassword(@Param("pass") String pass, @Param("id") int uerId);
	
	//删除书架上的图书(mybooks),id表示mybooks上的主键
	public void deleteMyBook(@Param("id") int id);
	
	//加入书架
	public Integer addMyBook(MyBookDo book);
	
	//获取个人信息(user-info-mybooks-user_books-user_type-user_writer-identity-orders-cart-system_news)
	public User getMyAllInfos(@Param("id") int id);
	
	//获取近期阅读图书信息
	public List<RecentReadingBook> getRecentReadingBooks(@Param("id") int id);
	//插入阅读记录
	public Integer InsertRecentReadingBook(@Param("userId") int uid,@Param("bookId") int bid);
	//查找该记录
	public Integer isExistRecentReadingBook(@Param("uid") int uid,@Param("bid") int bid);
	//判断是否有该记录
	public Integer hasReading(@Param("userId") int uid,@Param("bookId") int bid);
	
	//更改个人信息
	public Integer changeMyInfos(UserInfomations userInfos);
	//设置个人信息
	public Integer setMyInfos(UserInfomations userInfos);
	//更新最后一次阅读该书的时间
	public void changeReadingTime(@Param("id")int id);//id为user_books的主键
	
	//获取购物车信息(cart)
	public List<Book> getMyCart(@Param("ids")List<Integer> bookIds);
	public List<Integer> BookIdsOfMyCart(@Param("id")int userId);
	public int getCartId(@Param("uid") int uid,@Param("bid") int bid);
	
	
	//添加购物车
	public int addBookToMyCart(@Param("uid")int userId,@Param("bid")int bookId);
	//查看购物车数量
	public int numOfMyCart(@Param("id") int userId);
	
	//删除购物车上的图书(mybooks),id表示cart上的主键
	public void deleteMyCart(@Param("id")int cartId);
	
	//购买
	public Integer buyBook(@Param("bid")int bid,@Param("uid") int uid);
	public Integer addBook(@Param("bid")int bid,@Param("uid") int uid);
	public Integer isBuyBook(@Param("bid")int bid,@Param("uid") int uid);
	public void deleteCartBook(@Param("bid")int bid,@Param("uid") int uid);
	public void addOne(@Param("id") int bid);
	
	//添加订单
	public Float getPrice(@Param("bid")int bid);
	public void addOrder(@Param("bid")int bid,@Param("uid") int uid,@Param("price")float price);
	
	//获取系统消息(system_news-reading)
	
}
