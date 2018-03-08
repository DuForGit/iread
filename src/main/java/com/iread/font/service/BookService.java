package com.iread.font.service;

import java.util.Map;

/**
 *项目名称: iread
 *类名称: BookService
 *类描述: 
 * @author 方秋都
 *
 */
public interface BookService {
	//1.查询书架上是否有该书籍
	//2.查询购物车是否有该书籍
	//3.查询该书信息
	//4.查询该书目录信息(不提供链接)
	Map<String, Object> ebook(int uid,int bid);
	
	Map<String,Object> ebook(int bid);
	
	//1.查找目录(判断是否已购买,已购买提供目录的所有链接，未购买提供试读部分链接)
	//2.根据目录第一行数据查询正文数据并显示
	Map<String, Object> showtext(int uid,int bid);
	Map<String, Object> showtext(int bid);
	
	//1.判断是否可以获取该信息
	//2.可以访问就查询该数据
	//3.查询上一个目录和下一个目录
	Map<String, Object> text(int uid,int tid,int bid);
	Map<String, Object> text(int tid,int bid);
}
