package com.iread.font.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iread.beans.domain.Book;
import com.iread.beans.domain.RankNav;

/**
 *项目名称: iread
 *类名称: RankMapper
 *类描述: 处理rank页面
 *创建人: Administrator
 *创建时间: 2018年2月2日下午2:09:55
 * @version 1.0.0
 * @author 方秋都
 *
 */
public interface RankMapper {
	
	public List<RankNav> getRankNav();
	
	public List<Book> getRankBooks(@Param("order") Integer order);
	
}
