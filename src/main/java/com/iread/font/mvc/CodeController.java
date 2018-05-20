package com.iread.font.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iread.utils.CodeUtil;
import com.iread.utils.SendCodeToEmail;
import com.iread.utils.SessionKey;

/**
 *项目名称: iread
 *类名称: CodeController
 *类描述: 获取验证码
 *创建人: Administrator
 * @version
 * @author 方秋都
 *
 */
@Controller
@ResponseBody
public class CodeController {
	
	@RequestMapping("/code")
	public boolean  getCode(HttpServletRequest h,String email){
		HttpSession session = h.getSession();
		int code = CodeUtil.getCode();
		String em = h.getParameter("email");
		session.setAttribute(SessionKey.REGISTER_CODE, code);
		session.setAttribute(SessionKey.REGISTER_EMAIL, em);
		System.out.println("REGISTER_CODE：" + session.getAttribute(SessionKey.REGISTER_CODE));
		try{
			SendCodeToEmail.sendEmail(email, code);
		}catch(Exception e){
			return false;
		}
		//session.setMaxInactiveInterval(60);
		session.setAttribute(SessionKey.CODE_LIFE, System.currentTimeMillis());
		return true;
	}
}
