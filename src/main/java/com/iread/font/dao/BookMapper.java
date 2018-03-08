package com.iread.font.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iread.beans.domain.Book;
import com.iread.beans.domain.Chaper;
import com.iread.beans.domain.Text;

/**
 *项目名称: iread
 *类名称: BookMapper
 *类描述: 
 * @author 方秋都
 *
 */
public interface BookMapper {
	//书架上是否有该数据
	public Integer isExistBook(@Param("uid") int uid,@Param("bid") int bid);
	//购物车上是否有该数据
	public Integer isExistBookInMyCart(@Param("uid") int uid,@Param("bid") int bid);
	//是否已购买该书
	public Integer isBuyBook(@Param("id") int uid,@Param("bid") int bid);
	//获取试读页数
	public int getPages(@Param("id") int id);
	//根据可读取的最大页数获取可读取的最后一个text id
	public /*int*/Integer getMaxId(@Param("page") int page,@Param("bid") int bid);
	//查询该书目录
	public List<Chaper> getChaper(@Param("id") int bid);
	//查询该书信息
	public Book getBookInfo(@Param("id") int bid);
	
	//查询正文信息
	public Text getText(@Param("id") int tid);
	
	//添加阅读记录
	public void addReading(@Param("id") int bid);
	//添加搜索记录
	public void addSearch(@Param("ids") List<Integer> ids);
	
	
	
}
