package com.iread.beans.domain;

import java.util.List;

/**
 *项目名称: iread
 *类名称: Class
 *类描述: 
 *创建人: Administrator
 *创建时间: 2017年11月13日下午5:01:32
 * @version
 * @author 方秋都
 *
 */
public class Class {
	private Integer id;
	private String name;
	private List<Type> types;
	
	public List<Type> getTypes() {
		return types;
	}
	public void setTypes(List<Type> types) {
		this.types = types;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
