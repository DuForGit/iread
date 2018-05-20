package com.iread.beans.domain;

/**
 *项目名称: iread
 *类名称: AlipayOrder
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月31日下午10:10:23
 * @version
 * @author 方秋都
 *
 */
public class AlipayOrder {
	private int id;
	private String title;
	private String writer;
	private String publish;
	private float price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "AlipayOrder [id=" + id + ", title=" + title + ", writer=" + writer + ", publish=" + publish + ", price="
				+ price + "]";
	}
	
	
}
