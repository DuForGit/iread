package com.iread.font.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 *项目名称: iread
 *类名称: ErrorPage
 *类描述: 404错误页面处理
 *创建人: Administrator
 *创建时间: 2017年11月30日下午10:09:57
 * @version
 * @author 方秋都
 *
 */
@Controller
public class ErrorPage {
	@RequestMapping(value="/404",method=GET)
	public String error(){
		return "404";
	}
}
