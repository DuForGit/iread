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
		session.setMaxInactiveInterval(60);
		System.out.println("5231515611156156");
		return true;	
	}
	
	@RequestMapping(value="/setpass",method=POST)
	@ResponseBody
	public boolean setPass(HttpServletRequest request,String email,int code){
		int co = (int) request.getSession().getAttribute(SessionKey.GETPASS_CODE);
		String em = (String) request.getSession().getAttribute(SessionKey.GETPASS_EMAIL);
//		System.out.println("code: "+code + ";  email: " + email);
//		System.out.println("sessioncode: "+co + ";  sessionemail: " + em);
		request.getSession().setAttribute(SessionKey.IS_SUBMIT, true);
		if(code == co && email.equals(em)){
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
		boolean success = user.changePass(email, pass);
		request.getSession().removeAttribute(SessionKey.GETPASS_EMAIL);
		return success;
	}
	
	//request.getSession().removeAttribute(SessionKey.IS_SUBMIT);
	
}
