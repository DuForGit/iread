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
	private String summary;//简介
	private String cover;//封面
	private Integer visit;//访问量
	private Integer sales;//出版社书籍销量
	private Integer readers;//出版社书籍总阅读量
	
	public Integer getVisit() {
		return visit;
	}
	public void setVisit(Integer visit) {
		this.visit = visit;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public Integer getReaders() {
		return readers;
	}
	public void setReaders(Integer readers) {
		this.readers = readers;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
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
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	
	
}
