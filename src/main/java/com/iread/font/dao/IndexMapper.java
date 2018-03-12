package com.iread.font.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iread.beans.domain.Book;

/**
 *项目名称: iread
 *类名称: IndexMapper
 *类描述: 首页模块实现
 * @author 方秋都
 *
 */
public interface IndexMapper {
	List<Book> getNewBooks();
	List<Book> getHotBooks();
	List<Book> getHotSaleBooks();
	
	/*//获取符合类型的记录数
	int getMaxNumOfBooksByTypeId(@Param("tid") int tid);
	//获取符合类型的记录数
	int getMaxNumOfBooksByTypeIds(@Param("tids") List<Integer> tids);*/
	
}
