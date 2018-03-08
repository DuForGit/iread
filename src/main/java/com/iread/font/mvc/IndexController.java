package com.iread.font.mvc;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *项目名称: iread
 *类名称: IndexController
 *类描述: 首页index访问控制器
 *创建人: Administrator
 *创建时间: 2017年11月30日下午9:20:49
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Controller
public class IndexController {
	@RequestMapping(value={"/index","/"},method=GET)
	public String index(){
		return "index";
	}
}
