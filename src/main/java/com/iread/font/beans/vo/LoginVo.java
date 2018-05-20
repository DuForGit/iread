package com.iread.font.beans.vo;

/**
 *项目名称: iread
 *类名称: LoginVo
 *类描述: 登录表对象
 *创建人: Administrator
 *创建时间: 2017年12月22日下午9:46:35
 * @version 1.0.0
 * @author 方秋都
 *
 */
public class LoginVo {
	private String name;//包含用户名、邮箱等
	private String pass;
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
	@Override
	public String toString() {
		return "LoginVo [name=" + name + ", pass=" + pass + "]";
	}
	
	
}
