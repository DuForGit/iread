package com.iread.font.service.impl;


import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iread.beans.domain.User;
import com.iread.font.dao.UserMapper;
import com.iread.font.service.LoginService;
import com.iread.utils.RegexUtil;

/**
 *项目名称: iread
 *类名称: LoginServiceImpl
 *类描述: LoginService的具体实现
 */
@Service
public class LoginServiceImpl implements LoginService {
	/*//邮箱
	public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	//手机
	public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";*/
	@Autowired
	private UserMapper userMapper;

	/* (non-Javadoc)
	 * @see com.iread.font.service.LoginService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public Integer login(String name, String pass) {
		Integer id;
		if(Pattern.matches(RegexUtil.REGEX_EMAIL,name)){
			id = userMapper.getUserByEmail(name, pass);
		}else{
			id = userMapper.getUserByName(name, pass);
		}
		System.out.println("loginservice: " + id);
		return id;
	}

}
