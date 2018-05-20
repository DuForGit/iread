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
 *类名称: RegisterInterceptor
 *类描述: 用户注册拦截器
 *
 */
public class RegisterInterceptor implements HandlerInterceptor{
	
	/*//邮箱
	public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	//手机
	public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
	//名字
	public static final String REGEX_NAME = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";
	//密码
	public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$";
	//验证码
	public static final String REGEX_CODE = "^[0-9]{6}$";*/
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getSession().getAttribute(SessionKey.IS_SUBMIT_REGISTER_REQUEST) == null){
			System.out.println("SessionKey.IS_SUBMIT_REGISTER_REQUEST为空");
			response.sendRedirect("/reg");
			return false;
		}
		
		

			int reg = (int)request.getSession().getAttribute(SessionKey.IS_SUBMIT_REGISTER_REQUEST);//提交注册次数，防止重复提交
			if(reg > 0){
				System.out.println("注册信息重复提交" );
				response.sendRedirect("/reg");
				return false;
			}
			request.getSession().setAttribute(SessionKey.IS_SUBMIT_REGISTER_REQUEST, reg + 1);

		
		if(request.getSession().getAttribute(SessionKey.USER_ID) == null){
			String email =request.getParameter("email");
			String name = request.getParameter("name");
			String pass = request.getParameter("password");
			String code = request.getParameter("code");
			if(email.matches(RegexUtil.REGEX_EMAIL)
					&& name.matches(RegexUtil.REGEX_NAME) 
					&& pass.matches(RegexUtil.REGEX_PASSWORD)
					&& code.matches(RegexUtil.REGEX_CODE)){
				System.out.println("正则表达式正确");
				return true;
			}
		}
		System.out.println("正则表达式错误");
		response.sendRedirect("/reg");
		return false;
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
