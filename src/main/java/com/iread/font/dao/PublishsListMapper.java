package com.iread.font.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iread.beans.domain.Publish;

/**
 *项目名称: iread
 *类名称: PublishsListMapper
 *类描述:  关于publish的处理
 *创建人: Administrator
 *创建时间: 2018年2月1日下午4:49:07
 * @version 1.0.0
 * @author 方秋都
 *
 */
public interface PublishsListMapper {
	public List<Publish> getPublishs(@Param("order")  Integer order);
}
