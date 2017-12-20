package com.iread.font.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

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
public class Register {
	@RequestMapping(value="/reg",method = GET)
	public String register(){
		return "register";
	}
	
	
	
}
