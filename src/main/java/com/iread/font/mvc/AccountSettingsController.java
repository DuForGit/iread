package com.iread.font.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.servlet.http.HttpSession;

/**
 *项目名称: iread
 *类名称: AccountSettingsController
 *类描述: 账号设置的相关处理，包括密码更改、找回密码，个人信息更改等
 *创建人: Administrator
 *创建时间: 2017年12月2日下午11:14:24
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Controller
public class AccountSettingsController {
	
	//找回密码
	@RequestMapping(value="/getpass", method=GET)
	public String getPass(HttpSession session){
		return "accountsettings";
	}
}
