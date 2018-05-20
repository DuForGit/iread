package com.iread.utils;

import java.util.Calendar;
import java.util.TimeZone;

/**
 *项目名称: iread
 *类名称: OrderUtil
 *类描述: 购书订单编码；由购买日期 + bookID + userID + bookID的长度组成
 *创建人: Administrator
 *创建时间: 2018年3月31日下午10:32:52
 * @version
 * @author 方秋都
 *
 */
public class OrderUtil {
	private OrderUtil(){}
	public static OrderUtil getInstance(){
		return new OrderUtil();
	}
	public String bookOrder(final int bid,final int uid){
		Calendar now = Calendar.getInstance();
		return  "" +
				formatDate(now.get(Calendar.YEAR)) +
				formatDate(now.get(Calendar.MONTH) + 1) + 
				formatDate(now.get(Calendar.DAY_OF_MONTH)) + 
				formatDate(now.get(Calendar.HOUR_OF_DAY)) + 
				formatDate(now.get(Calendar.MINUTE)) + 
				formatDate(now.get(Calendar.SECOND)) + 
				formatID(uid) + formatID(bid);	
	}
	//格式化日期
	private static String formatDate(int date){
		if(String.valueOf(date).length() == 1){
			return "0" + date;
		}
		return "" + date;
	}
	//格式化bookId和userId
	private static String formatID(int id){
		StringBuilder format = new StringBuilder();
		int len = String.valueOf(id).length();
		System.out.println("len: "+len + "; id: "+id);
		for(int i = len;i < 5; i++){
			format = format.append(0);
		}
		format.append(id);
		return format.toString();
	}
	
}
