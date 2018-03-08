package com.iread.beans.domain;

import java.util.List;

/**
 *项目名称: iread
 *类名称: AIIAboutMe
 *类描述: 关于user的所有信息
 * @author 方秋都
 *
 */
public class AIIAboutMe {
	private User user;
	private List<RecentReadingBook> books;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<RecentReadingBook> getBooks() {
		return books;
	}
	public void setBooks(List<RecentReadingBook> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "AIIAboutMe [user=" + user + ", books=" + books + "]";
	}
	
	
	
	
}
