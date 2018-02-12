package com.iread.font.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 *项目名称: iread
 *类名称: SearchWriterMapper
 *类描述: 
 *创建人: Administrator
 *创建时间: 2017年11月17日下午11:26:00
 * @version
 * @author 方秋都
 *
 */
public interface SearchWriterMapper {
	
	/**
	 *根据作者姓名返回作者的ID集合(模糊查询)，这是因为有可能作者名字相同
	 *@param wName 作者姓名
	 *@return 作者的ID集合（因为有可能有多个姓名相同的作者）
	 */
	public List<Integer> getWriterIds(@Param("wName")String wName);
	
	public Integer getWriterId(@Param("wName") String wName);

}
