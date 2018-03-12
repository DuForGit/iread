package com.iread.utils;

/**
 *项目名称: iread
 *类名称: UserContext
 *类描述: 保存session的一些键值
 *创建人: Administrator
 * @version 1.0.0
 * @author 方秋都
 *
 */
public class SessionKey {
	//用户ID
	public final static String USER_ID = "userId";
	//注册验证码
	public final static String REGISTER_CODE = "registerCode";
	//验证码邮箱
	public final static String REGISTER_EMAIL = "registerEmail";
	//提交验证码，防止重复提交
	public final static String IS_SUBMIT = "isSubmit";
	//找回密码验证邮箱
	public final static String GETPASS_EMAIL = "getpassEmail";
	//找回密码验证码
	public final static String GETPASS_CODE = "getpassCode";
}
