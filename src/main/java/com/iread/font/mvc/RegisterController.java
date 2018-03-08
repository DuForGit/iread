package com.iread.font.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iread.beans.domain.User;
import com.iread.beans.domain.UserIdentify;
import com.iread.beans.domain.UserInfomations;
import com.iread.font.beans.vo.RegisterVo;
import com.iread.font.service.RegisterService;
import com.iread.utils.SessionKey;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *项目名称: iread
 *类名称: RegisterPage
 *类描述: 关于注册操作的全部实现，包括注册页面的URL映射、注册过程的一系列处理方法
 *创建人: Administrator
 *创建时间: 2017年12月2日下午4:45:13
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Controller
public class RegisterController {
	
	@Autowired
	private RegisterService reg;
	
	@RequestMapping(value="/reg",method = GET)
	public String register(){
		return "register";
	}
	
	//注册功能
	@RequestMapping(value="/postUser",method=POST)
	@ResponseBody
	public String register(RegisterVo re,HttpServletRequest h){
		int code = re.getCode();
		int emailCode = (int) h.getSession().getAttribute(SessionKey.REGISTER_CODE);
		String sessionEmail = (String) h.getSession().getAttribute(SessionKey.REGISTER_EMAIL);
		String reEmail = re.getEmail();
		if(emailCode == code && reEmail.equals(sessionEmail)){
			Integer uId = reg.register(re);
			if(uId != null){
				h.getSession().setAttribute(SessionKey.USER_ID, uId);
				return h.getContextPath();
			}
		}
		return h.getContextPath() + "/reg";
	}
	
	
		//判断邮箱是否已被注册
		@RequestMapping(value="/isExistEmail",method=RequestMethod.POST)
		@ResponseBody
		public boolean isExistEmail(String email){
			boolean is =  reg.isExistEmail(email);
			System.out.println("is: "+is);
			return is;
		}
		//判断邮箱是否已被注册
		@RequestMapping(value="/isExistName",method=RequestMethod.POST)
		@ResponseBody
		public boolean isExistName(String name){
			boolean is =  reg.isExistName(name);
			System.out.println("is: "+is);
			return is;
		}
	
	

	
	//信息填写功能
	@RequestMapping(value="/postInfo",method=POST)
	public String register(UserInfomations uinfo){
		
		return "";
	}
	
}
