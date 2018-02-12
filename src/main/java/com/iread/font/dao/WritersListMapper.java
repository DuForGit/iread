package com.iread.font.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iread.beans.domain.Writer;

/**
 *项目名称: iread
 *类名称: WritersListMapper
 *类描述: 关于writers列表的处理
 *创建人: Administrator
 *创建时间: 2018年1月30日下午5:41:50
 * @version 1.0.0
 * @author 方秋都
 *
 */
public interface WritersListMapper {

	public List<Writer> getWriters(@Param("order") Integer order);
	
}
