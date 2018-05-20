package com.iread.font.mvc;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iread.beans.domain.UserInfomations;
import com.iread.font.beans.vo.RegisterVo;
import com.iread.font.service.RegisterService;
import com.iread.utils.SessionKey;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.servlet.http.HttpServletRequest;
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
	public String register(HttpServletRequest request){
		request.getSession().setAttribute(SessionKey.IS_SUBMIT_REGISTER_REQUEST, 0);//防止重复提交注册信息
		request.getSession().setAttribute(SessionKey.IS_SUBMIT_LOGIN_REQUEST, 0);//防止重复提交登录信息
		request.getSession().setAttribute(SessionKey.IS_SUBMIT_CODE_REQUEST, 0);//防止重复提交验证码信息
		return "register";
	}
	
	//注册功能
	@RequestMapping(value="/postUser",method=POST)
	@ResponseBody
	public String register(RegisterVo re,HttpServletRequest h){
		
		long start = (long)h.getSession().getAttribute(SessionKey.CODE_LIFE);//验证码创建阶段
		long end = System.currentTimeMillis();//验证码失效阶段阶段
		System.out.println("shijian:"+(end-start));
		if(end - start > 60*1000){
			System.out.println("验证码生命时间超过");
			return h.getContextPath() + "/reg";
		}
		
		int code = re.getCode();
		int emailCode = (int) h.getSession().getAttribute(SessionKey.REGISTER_CODE);
		String sessionEmail = (String) h.getSession().getAttribute(SessionKey.REGISTER_EMAIL);
		String reEmail = re.getEmail();
		if(emailCode == code && reEmail.equals(sessionEmail)){
			Integer uId = reg.register(re);
			if(uId != null){
				h.getSession().removeAttribute(SessionKey.IS_SUBMIT_REGISTER_REQUEST);
				h.getSession().removeAttribute(SessionKey.IS_SUBMIT_LOGIN_REQUEST);
				h.getSession().removeAttribute(SessionKey.IS_SUBMIT_CODE_REQUEST);
				h.getSession().removeAttribute(SessionKey.CODE_LIFE);
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
