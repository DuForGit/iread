package com.iread.font.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iread.utils.SessionKey;

/**
 *项目名称: iread
 *类名称: CodeInterceptor
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年4月15日上午1:20:29
 * @version
 * @author 方秋都
 *
 */
public class CodeInterceptor implements HandlerInterceptor {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getSession().getAttribute(SessionKey.IS_SUBMIT_CODE_REQUEST) == null){
			System.out.println("SessionKey.IS_SUBMIT_CODE_REQUEST为空");
			return false;
		}
		

			int submit = (int)request.getSession().getAttribute(SessionKey.IS_SUBMIT_CODE_REQUEST);//提交次数
			if(submit > 0){
				System.out.println("重复提交验证码");
				return false;
			}
			request.getSession().setAttribute(SessionKey.IS_SUBMIT_CODE_REQUEST, submit + 1);

		
		return true;
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
