package com.iread.beans.domain;


/**
 *项目名称: iread
 *类名称: Publish
 *类描述: 一个Publish对象对应一个出版社或者版权方
 *创建人: Administrator
 *创建时间: 2017年11月13日下午4:02:50
 * @version
 * @author 方秋都
 *
 */
public class Publish {
	private Integer id;
	private String name;//出版社、版权方名称
	private Integer num;//读者推荐人数
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
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	
	
}
