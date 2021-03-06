package com.iread.font.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iread.utils.SessionKey;

/**
 *项目名称: iread
 *类名称: ReSubmitIntercepter
 *类描述: 防止重复提交拦截器
 * @author 方秋都
 *
 */
public class ReSubmitIntercepter implements HandlerInterceptor{

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getSession().getAttribute(SessionKey.IS_SUBMIT_CHANGEPASS_REQUEST) == null){
			System.out.println("SessionKey.IS_SUBMIT_CHANGEPASS_REQUEST为空");
			return false;
		}
		int change = (int)request.getSession().getAttribute(SessionKey.IS_SUBMIT_CHANGEPASS_REQUEST);
		if(change > 0){
			System.out.println("修改密码重复提交");
			return false;
		}
		request.getSession().setAttribute(SessionKey.IS_SUBMIT_CHANGEPASS_REQUEST, change + 1);
		/*if(request.getSession().getAttribute(SessionKey.IS_SUBMIT) == null
				|| (boolean) request.getSession().getAttribute(SessionKey.IS_SUBMIT) == true){
			System.out.println("验证通过");
			return false;
		}*/
		System.out.println("ReSubmitIntercepter通过");
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
