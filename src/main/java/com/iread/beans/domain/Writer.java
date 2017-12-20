package com.iread.beans.domain;


/**
 *项目名称: iread
 *类名称: Writer
 *类描述: 一个Writer对象对应一個作家
 *创建人: Administrator
 *创建时间: 2017年11月13日下午4:00:28
 * @version
 * @author 方秋都
 *
 */
public class Writer {
	private Integer id;
	private String name;//作者姓名
	private Integer num;//读者推荐人量
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
