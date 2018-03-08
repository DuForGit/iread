package com.iread.font.service;


import com.iread.beans.domain.UserInfomations;
import com.iread.font.beans.vo.RegisterVo;

/**
 *项目名称: iread
 *类名称: RegisterService
 *类描述: 关于注册功能的服务层的一系列实现
 *创建人: Administrator
 *创建时间: 2017年12月20日下午1:01:27
 * @version 1.0.0
 * @author 方秋都
 *
 */
public interface RegisterService {

	//注册功能实现，对应注册页面的信息操作
	Integer register(RegisterVo u);
	
	//个人信息填写
	Integer register(UserInfomations uinfo);
	
	//TRUE表示存在，FALSE表示不存在
	boolean isExistEmail(String email);
	//TRUE表示存在，FALSE表示不存在--判断是否有该名称
	boolean isExistName(String name);
	
}
