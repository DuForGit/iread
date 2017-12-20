package com.iread.beans.domain;


/**
 *项目名称: iread
 *类名称: Type
 *类描述: 类型
 *创建人: Administrator
 *创建时间: 2017年11月13日下午4:53:31
 * @version
 * @author 方秋都
 *
 */
public class Type {
	private Integer id;
	private String name;
	private Class clazz;
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
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	
	
	
}
