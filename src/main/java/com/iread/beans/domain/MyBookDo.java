package com.iread.beans.domain;

/**
 *项目名称: iread
 *类名称: MyBookDo
 *类描述: 书架图书domain
 * @author 方秋都
 *
 */
public class MyBookDo {
	private Integer id;
	private Integer userId;
	private Integer bookId;
	private boolean payment = false;//支付状态
	private Integer point = 0;//锚点（阅读的章节）
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public boolean isPayment() {
		return payment;
	}
	public void setPayment(boolean payment) {
		this.payment = payment;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "MyBookDo [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", payment=" + payment + ", point="
				+ point + "]";
	}
	
	
	
	
}
