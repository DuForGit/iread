package com.iread.font.mvc;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,LoginVo vo){
		Integer id= login.login(vo.getName(), vo.getPass());
		if(id == null){
			System.out.println("user为null");
			return "redirect:/reg";
		}
		request.getSession().setAttribute(SessionKey.USER_ID, id);
		System.out.println("登录成功");
		return "redirect:/index";
	}
}
