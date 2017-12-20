package com.iread.font.dao;

import com.iread.beans.domain.User;
import com.iread.beans.domain.UserInfomations;

/**
 *项目名称: iread
 *类名称: RegisterUserMapper
 *类描述: 用于注册的相关操作；包括注册表单的数据录入，
 *创建人: Administrator
 *创建时间: 2017年12月19日下午3:34:58
 * @version 1.0.0
 * @author 方秋都
 *
 */
public interface RegisterUserMapper {
	
	//注册页面的注册操作方法
	public Integer regisetUser(User u);
	
	//填写个人信息,
	public Integer regisetInfo(UserInfomations info);
	
}
