package com.iread.beans.domain;

/**
 *项目名称: iread
 *类名称: OrderWriter
 *类描述: 订单中作者信息
 * @author 方秋都
 *
 */
public class OrderWriter {
private Integer id;
private String name;
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
@Override
public String toString() {
	return "OrderWriter [id=" + id + ", name=" + name + "]";
}

}
