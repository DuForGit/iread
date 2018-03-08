package com.iread.beans.domain;

import java.util.Date;

import org.springframework.stereotype.Component;
import com.iread.beans.domain.Nation;
import com.iread.beans.domain.Publish;
import com.iread.beans.domain.Type;
import com.iread.beans.domain.Writer;

/**
 *项目名称: iread
 *类名称: Book
 *类描述: Book类包含电子书的全部信息，一个Book对象对应一本电子书
 *创建人: 方秋都
 *创建时间: 2017年11月13日下午3:42:16
 * @version 1.1.0
 * @author 方秋都
 *
 */
@Component("book")
public class Book {
	private Integer id;//主键ID
	private String title;//书名
	private Writer writer;//作者
	private Publish publish;//出版社/版权方
	private Float price;//价格
	private Nation nation;//作家国籍
	private String summary;//概要
	private Integer reader;//读者人数
	private Integer valuator;//评论者人数
	private Float grade;//平均评分（数据库为int，改）
	private Integer text;//正文地址（数据库为String，改）
	private String cover;//封面地址（数据库为String，改）
	private Type type;//书籍详细种类
	//private Class clazz;//书籍类型(可删，因为Type类中以及包含该对象，更改数据库books表)
	private Integer num;//推荐人数
	private Date payaway;//上架时间
	private Date soldout;//下架时间
	private Integer limit;//试读页数
	private Integer sales;//销量
	private Integer search;//搜索量
	
	
	
	public Integer getSearch() {
		return search;
	}
	public void setSearch(Integer search) {
		this.search = search;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Writer getWriter() {
		return writer;
	}
	public void setWriter(Writer writer) {
		this.writer = writer;
	}
	public Publish getPublish() {
		return publish;
	}
	public void setPublish(Publish publish) {
		this.publish = publish;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Nation getNation() {
		return nation;
	}
	public void setNation(Nation nation) {
		this.nation = nation;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Integer getReader() {
		return reader;
	}
	public void setReader(Integer reader) {
		this.reader = reader;
	}
	public Integer getValuator() {
		return valuator;
	}
	public void setValuator(Integer valuator) {
		this.valuator = valuator;
	}
	public Float getGrade() {
		return grade;
	}
	public void setGrade(Float grade) {
		this.grade = grade;
	}
	public Integer getText() {
		return text;
	}
	public void setText(Integer text) {
		this.text = text;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Date getPayaway() {
		return payaway;
	}
	public void setPayaway(Date payaway) {
		this.payaway = payaway;
	}
	public Date getSoldout() {
		return soldout;
	}
	public void setSoldout(Date soldout) {
		this.soldout = soldout;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", writer=" + writer + ", publish=" + publish + ", price="
				+ price + ", nation=" + nation + ", summary=" + summary + ", reader=" + reader + ", valuator="
				+ valuator + ", grade=" + grade + ", text=" + text + ", cover=" + cover + ", type=" + type + ", num="
				+ num + ", payaway=" + payaway + ", soldout=" + soldout + ", limit=" + limit + ", sales=" + sales
				+ ", search=" + search + "]";
	}
	
	
	
	
}
