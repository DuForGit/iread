package com.iread.font.beans.vo;

/**
 *项目名称: iread
 *类名称: RegisterVo
 *类描述: 注册表对象
 *创建人: Administrator
 *创建时间: 2017年12月22日下午9:47:35
 * @version 1.0.0
 * @author 方秋都
 *
 */
public class RegisterVo {

	private String name;
	private String email;
	private String password;
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "RegisterVo [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
}
