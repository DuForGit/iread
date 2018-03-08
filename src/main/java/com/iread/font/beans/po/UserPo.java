package com.iread.font.beans.po;

/**
 *项目名称: iread
 *类名称: UserPo
 *类描述: 
 * @author 方秋都
 *
 */
public class UserPo {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String pass;
	
	
	
	public UserPo() {
	}
	public UserPo( String name, String email, String phone, String pass) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.pass = pass;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
