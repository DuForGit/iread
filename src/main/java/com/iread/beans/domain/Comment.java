package com.iread.beans.domain;

import java.util.Date;

/**
 *项目名称: iread
 *类名称: Comment
 *类描述: 评论
 * @author 方秋都
 *
 */
public class Comment {
	private Integer id;
	private String comment;
	private String userName;
	private Date date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + ", userName=" + userName + ", date=" + date + "]";
	}
	
	
	
	
}
