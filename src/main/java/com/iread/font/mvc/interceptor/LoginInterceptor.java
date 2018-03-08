package com.iread.font.mvc.interceptor;

/*import java.util.regex.Pattern;*/


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iread.utils.RegexUtil;
import com.iread.utils.SessionKey;

/**
 *项目名称: iread
 *类名称: LoginIntercepter
 *类描述: 登录拦截器
 *创建人: Administrator
 *创建时间: 2017年12月2日下午4:53:12
 * @version 1.0.0
 * @author 方秋都
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	/*//密码规范
	public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$";
	//名称规范
	public static final String REGEX_NAME = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";*/
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Integer id = (Integer) request.getSession().getAttribute(SessionKey.USER_ID);
		String path = request.getContextPath();
		if(id == null){//表示未登录，需要在登录或注册
			String pass = request.getParameter("pass");
			String name = request.getParameter("name");
			System.out.println("拦截器：name-" + name + ";pass-" + pass);
			if((name.matches(RegexUtil.REGEX_NAME) || 
					name.matches(RegexUtil.REGEX_EMAIL) || 
					name.matches(RegexUtil.REGEX_MOBILE)) &&
					pass.matches(RegexUtil.REGEX_PASSWORD)){
				return true;
			}else{
				response.sendRedirect(path + "/reg");
				System.out.println("拦截器：格式错误");
				return false;
			}
		}
		response.sendRedirect(path + "/");
		System.out.println("拦截器：已经登录");
		return false;
		
		
/*		response.sendRedirect(path + "/reg");
		return  false;*/
		
		
		
		
		
		
				/*(name.matches(RegexUtil.REGEX_NAME) || 
				name.matches(RegexUtil.REGEX_EMAIL) || 
				name.matches(RegexUtil.REGEX_MOBILE)) &&
				pass.matches(RegexUtil.REGEX_PASSWORD);*/
				/*Pattern.matches(REGEX_PASSWORD, request.getParameter("pass")) && 
				Pattern.matches(REGEX_NAME, request.getParameter("name"));*/
	}

}
