package com.iread.beans.domain;

/**
 *项目名称: iread
 *类名称: User
 *类描述: 关于用户登录的基本信息，用于验证登录信息是否正确，与user表一一对应
 *创建人: Administrator
 *创建时间: 2017年12月19日下午3:46:07
 * @version
 * @author 方秋都
 *
 */
public class User {
	private Integer id;//ID
	private String name;//用户名
	private String pass;//密码
	private String email;//邮箱
	private Long phone;//手机
	private Boolean freeze;//是否被冻结，FALSE表示未被冻结，TRUE表示被冻结
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Boolean getFreeze() {
		return freeze;
	}
	public void setFreeze(Boolean freeze) {
		this.freeze = freeze;
	}
	
	
}
