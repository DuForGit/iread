package com.iread.beans.domain;

/**
 *项目名称: iread
 *类名称: UserIdentify
 *类描述: 对于identity表，用于生成一个身份(职业)对象，与相应的user对应。
 *创建人: Administrator
 *创建时间: 2017年12月19日下午6:53:39
 * @version 1.0.0
 * @author 方秋都
 *
 */
public class UserIdentify {
	private Integer id;
	private String type;//详细的类型；大学生、中学生、小学生
	private String clazz;//大概的类型；如学生
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	@Override
	public String toString() {
		return "UserIdentify [id=" + id + ", type=" + type + ", clazz=" + clazz + "]";
	}

	
}
