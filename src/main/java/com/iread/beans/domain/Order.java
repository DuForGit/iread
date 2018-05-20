package com.iread.beans.domain;

import java.util.Date;

/**
 *项目名称: iread
 *类名称: Order
 *类描述: 订单信息
 * @author 方秋都
 *
 */
public class Order {
	private Integer id;//订单ID
	private OrderBook book;//购买图书信息
	private Date date;//购买日期
	private Float price;//购买价格
	private String payID;//支付宝订单号
	private String orderID;//订单号
	
	
	
	public String getPayID() {
		return payID;
	}
	public void setPayID(String payID) {
		this.payID = payID;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public OrderBook getBook() {
		return book;
	}
	public void setBook(OrderBook book) {
		this.book = book;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", book=" + book + ", date=" + date + ", price=" + price + "]";
	}
	
	
	
}
