package com.iread.font.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 *项目名称: iread
 *类名称: SearchTypeMapper
 *类描述: 
 *创建人: Administrator
 *创建时间: 2017年11月17日下午11:29:49
 * @version
 * @author 方秋都
 *
 */
public interface SearchTypeMapper {
	
	/**
	 *返回Type类型的ID，模糊查询
	 *@param tName 类型名称
	 *@return Type的ID的集合
	 */
	public List<Integer> getIdsByGeneralType(@Param("tName")String tName);
	
	/**
	 *返回Class类型的ID，模糊查询
	 *@param cName 类型名称
	 *@return book的ID的集合
	 */
	public List<Integer> getIdsByGeneralClass(@Param("cName")String cName);
}
