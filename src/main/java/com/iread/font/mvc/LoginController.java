package com.iread.font.mvc;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iread.font.beans.vo.LoginVo;
import com.iread.font.service.LoginService;
import com.iread.utils.SessionKey;

/**
 *项目名称: iread
 *类名称: LoginController
 *类描述: 登录控制器
 *创建人: Administrator
 * @author 方秋都
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private LoginService login;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request,LoginVo vo){
		System.out.println("LoginVo: " + vo);
		Integer id= login.login(vo.getName(), vo.getPass());
		if(id == null){
			System.out.println("user为null");
			return "/reg";
		}
		request.getSession().setAttribute(SessionKey.USER_ID, id);
		request.getSession().removeAttribute(SessionKey.IS_SUBMIT_REGISTER_REQUEST);
		request.getSession().removeAttribute(SessionKey.IS_SUBMIT_LOGIN_REQUEST);
		request.getSession().removeAttribute(SessionKey.IS_SUBMIT_CODE_REQUEST);
		System.out.println("登录成功");
		return "/index";
	}
}
