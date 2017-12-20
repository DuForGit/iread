package com.iread.font.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 *项目名称: iread
 *类名称: SearchPublishMapper
 *类描述: 
 *创建人: Administrator
 *创建时间: 2017年11月17日下午11:26:20
 * @version
 * @author 方秋都
 *
 */
public interface SearchPublishMapper {
	
	/**
	 *返回Publish类型的ID，模糊查询
	 *@param pName 类型名称
	 *@return Publish的ID的集合
	 */
	public List<Integer> getIdsByGeneralPublish(@Param("pName")String pName);
}
