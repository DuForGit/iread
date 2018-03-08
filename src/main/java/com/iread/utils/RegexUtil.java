package com.iread.utils;

/**
 *项目名称: iread
 *类名称: RegexUtil
 *类描述: 一系列正则表达式
 * @author 方秋都
 *
 */
public class RegexUtil {
	private RegexUtil(){}
	//邮箱
	public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	//手机
	public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
	//名字
	public static final String REGEX_NAME = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";
	//密码
	public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$";
	//验证码
	public static final String REGEX_CODE = "^[0-9]{6}$";
}
