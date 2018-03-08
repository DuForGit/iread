package com.iread.beans.domain;

/**
 *项目名称: iread
 *类名称: Cart
 *类描述: 购物车信息
 * @author 方秋都
 *
 */
public class Cart {
	private Integer id;//购物车ID
	private Book book;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", book=" + book + "]";
	}
	
}
