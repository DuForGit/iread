package com.iread.beans.domain;

/**
 *项目名称: iread
 *类名称: OrderPublish
 *类描述: 订单中出版社信息
 * @author 方秋都
 *
 */
public class OrderPublish {
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
	return "OrderPublish [id=" + id + ", name=" + name + "]";
}

}
