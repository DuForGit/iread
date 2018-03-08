package com.iread.beans.domain;


/**
 *项目名称: iread
 *类名称: OrderBook
 *类描述: 订单中book的基本信息
 * @author 方秋都
 *
 */
public class OrderBook {
	private Integer id;
	private String title;//书名
	private String cover;//封面地址
	private OrderWriter writer;//作者
	private OrderPublish publish;//出版社/版权方
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public OrderWriter getWriter() {
		return writer;
	}
	public void setWriter(OrderWriter writer) {
		this.writer = writer;
	}
	public OrderPublish getPublish() {
		return publish;
	}
	public void setPublish(OrderPublish publish) {
		this.publish = publish;
	}
	@Override
	public String toString() {
		return "OrderBook [id=" + id + ", title=" + title + ", cover=" + cover + ", writer=" + writer + ", publish="
				+ publish + "]";
	}

	
	
	
}
