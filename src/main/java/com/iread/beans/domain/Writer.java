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
	private String summary;//简介
	private String cover;//头像
	private String gender;//性别
	private Double avgSales;//作品平均销量
	private Double avgGrade;//作品平均评分
	
	public Double getAvgSales() {
		return avgSales;
	}
	public void setAvgSales(Double avgSales) {
		this.avgSales = avgSales;
	}
	public Double getAvgGrade() {
		return avgGrade;
	}
	public void setAvgGrade(Double avgGrade) {
		this.avgGrade = avgGrade;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
