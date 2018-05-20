package com.iread.beans.domain;

/**
 *项目名称: iread
 *类名称: BookInAction
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月21日下午10:20:45
 * @version
 * @author 方秋都
 *
 */
public class BookInAction {
	private int id;
	private String cover;
	private int bookId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	@Override
	public String toString() {
		return "BookInAction [id=" + id + ", cover=" + cover + ", bookId=" + bookId + "]";
	}
	
}
