package com.iread.beans.domain;

/**
 *项目名称: iread
 *类名称: Chaper
 *类描述: 目录
 * @author 方秋都
 *
 */
public class Chaper {
	private int id;
	private String name;
	private Text text;
	private int teid;
	
	
	
	public int getTeid() {
		return teid;
	}
	public void setTeid(int teid) {
		this.teid = teid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Text getText() {
		return text;
	}
	public void setText(Text text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Chaper [id=" + id + ", name=" + name + ", text=" + text + ", teid=" + teid + "]";
	}
	
	
	
	
}
