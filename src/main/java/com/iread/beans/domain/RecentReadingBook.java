package com.iread.beans.domain;

/**
 *项目名称: iread
 *类名称: RecentReadingBook
 *类描述: 近期阅读的图书（user_books）
 * @author 方秋都
 *
 */
public class RecentReadingBook {
	private Integer Id;//books表ID
	private String title;//书名
	private String cover;//封面地址
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
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

	
}
