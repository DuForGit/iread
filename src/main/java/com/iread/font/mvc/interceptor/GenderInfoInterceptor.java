package com.iread.font.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iread.utils.RegexUtil;

/**
 *项目名称: iread
 *类名称: GenderInfoInterceptor
 *类描述: 拦截用户填写信息时信息格式的准确性
 * @author 方秋都
 *
 */
public class GenderInfoInterceptor implements HandlerInterceptor{

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String gender = (String) request.getParameter("gender");
		System.out.println("gender拦截器："  + (gender == ""));
		if(isGender(gender)){return true;}
		if(gender == ""){
			return true;
		}
		System.out.println("拦截："+gender);
		return false;
	}
	private static final String[] genders = new String[]{"男","女","男生","女生","帅哥","美女","靓仔","靓女"};
	private static boolean isGender(String gen){
		boolean is = false;
		for( String gender : genders){
			if(gender.equals(gen)){is = true;}
		}
		return is;
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
