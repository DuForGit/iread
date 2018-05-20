package com.iread.font.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iread.font.service.UserService;
import com.iread.utils.CodeUtil;
import com.iread.utils.SendCodeToEmail;
import com.iread.utils.SessionKey;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *项目名称: iread
 *类名称: AccountSettingsController
 *类描述: 账号设置的相关处理，包括密码更改、找回密码，个人信息更改等
 *创建人: Administrator
 *创建时间: 2017年12月2日下午11:14:24
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Controller
public class AccountSettingsController {
	
	//找回密码
	@RequestMapping(value="/getpass", method=GET)
	public String getPass(HttpServletRequest request){
		request.getSession().setAttribute(SessionKey.IS_SUBMIT, false);
		request.getSession().setAttribute(SessionKey.IS_SUBMIT_CODE_REQUEST, 0);
		request.getSession().setAttribute(SessionKey.IS_SUBMIT_CHANGEPASS_REQUEST, 0);
		return "accountsettings";
	}
	
	@RequestMapping(value="/changecode",method=POST)
	@ResponseBody
	public boolean code(HttpServletRequest h,String email){
		HttpSession session = h.getSession();
		int code = CodeUtil.getCode();
		session.setAttribute(SessionKey.GETPASS_CODE, code);
		session.setAttribute(SessionKey.GETPASS_EMAIL, email);
		try{
			SendCodeToEmail.sendEmail(email, code);
		}catch(Exception e){
			return false;
		}
		//session.setMaxInactiveInterval(60);
		session.setAttribute(SessionKey.CODE_LIFE, System.currentTimeMillis());
		return true;	
	}
	
	@RequestMapping(value="/setpass",method=POST)
	@ResponseBody
	public boolean setPass(HttpServletRequest request,String email,int code){
		long start = (long)request.getSession().getAttribute(SessionKey.CODE_LIFE);//验证码创建阶段
		long end = System.currentTimeMillis();//验证码失效阶段阶段
		System.out.println("shijian:"+(end-start));
		if(end - start > 60*1000){
			System.out.println("验证码生命时间超过");
			return false;
		}
		request.getSession().removeAttribute(SessionKey.CODE_LIFE);
		int co = (int) request.getSession().getAttribute(SessionKey.GETPASS_CODE);
		String em = (String) request.getSession().getAttribute(SessionKey.GETPASS_EMAIL);
		System.out.println("co:" + co + "em:" + em);
		if(code == co && email.equals(em)){
			request.getSession().setAttribute(SessionKey.IS_SUBMIT, true);
			
			System.out.println("issubmit:" + request.getSession().getAttribute(SessionKey.IS_SUBMIT));
			return true;
		}else{	
			return false;
		}
	}
	@RequestMapping(value="/setmypass")
	public String setPass(){
		return "set";
	}
	
	@Autowired
	private UserService user;
	@RequestMapping(value="/submitnewpass",method=POST)
	@ResponseBody
	public boolean newPass(HttpServletRequest request,String pass){
		request.getSession().removeAttribute(SessionKey.IS_SUBMIT);
		String email = (String) request.getSession().getAttribute(SessionKey.GETPASS_EMAIL);
		request.getSession().removeAttribute(SessionKey.GETPASS_EMAIL);
		request.getSession().removeAttribute(SessionKey.GETPASS_CODE);
		request.getSession().removeAttribute(SessionKey.IS_SUBMIT_CODE_REQUEST);
		request.getSession().removeAttribute(SessionKey.IS_SUBMIT_CHANGEPASS_REQUEST);
		boolean success = user.changePass(email, pass);
		return success;
	}
	
	//request.getSession().removeAttribute(SessionKey.IS_SUBMIT);
	
}
