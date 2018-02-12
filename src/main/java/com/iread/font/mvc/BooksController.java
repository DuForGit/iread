package com.iread.font.mvc;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iread.beans.domain.Book;
import com.iread.font.service.BooksListService;
import com.iread.font.service.BooksNavListService;
import com.iread.utils.DeviceUtil;

/**
 *项目名称: iread
 *类名称: BooksController
 *类描述: books（分类页面）的相关映射,'/books'是关于分类页面的映射；{list}是关于图书类型的分类；{show}
 *			  是对{list}进行的类型细分；{list}和{show}对应相应类型表的主键值
 *创建人: Administrator
 *创建时间: 2017年12月24日下午7:12:09
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Controller
public class BooksController {
	
	//菜单栏
	@Autowired
	private BooksNavListService nav;
	
	//默认返回books列表
	@Autowired
	private BooksListService books;
	
	/**
	 * 
	 *方法名: books
	 *描述: 获取books列表
	 *@param
	 *@return
	 * @param list：类型的ID,前端没传入该值时表示查询全部books，只能是正整数;list=0表示全部，所以如果list=0，就不用考虑show参数了
	 * @param show：判断是根据class查询还是type查找,前端没传入该值时默认为0，只能为0或1，0表示按照class查询，1表示按照type查询
	 * @param page：分页
	 * @param order： 排序，默认为0，表示按照默认(热度)方法排序，1表示按照销量排序，2表示按照最新的排序，3表示按照评分排序，4表示按照价格排序，大于4的均默认为0
	 * @return book的列表，封装成json
	 */
	@ResponseBody
	@RequestMapping(value="/books/{list:^\\d+$}/{show:[01]{1}}",method=RequestMethod.GET)
	public /*List<Book>*/ Map<String, Object> booksList(@PathVariable(value="list",required=false) int list, 
			@PathVariable(value="show",required=false) int show,
			@RequestParam(value="p",required=false,defaultValue="1") int page, 
			@RequestParam(value="ord",required=false,defaultValue="0") int order){
		
		
		Map<String, Object> booksMap = null;//存放一页中的信息，包括books列表、分页相关信息
		//参数合理化
		if(order > 5){
			order = 0;
		}
		if(page<=0 || order<0){
			page = 1;order = 0;
		}
		//当list==0，表示不需要考虑类型问题
		if(list == 0){
				booksMap = books.getBooks(order, page);
		}else{
			boolean ifClass = true;//查询的类型
			//只有list不等于0，才需要考虑show的类型
			if(show != 0){
				ifClass = false;
			}
			booksMap = books.getBooks(list, ifClass, order, page);
		}
		return booksMap;//books.getBooksById(list, ifclass);
	}
	
	//返回分类页面
	@RequestMapping(value="/books",method=RequestMethod.GET)
	public String books(){
		return "books";
	}
	
	//获取默认的数据，在客户点击分类页面时请求
	//弃用
	/*@RequestMapping(value="/all",method=RequestMethod.GET)
	@ResponseBody
	public List<Book>Map<String, Object> getAllBooks(){
		return books.getBooks();
	}*/
	
	//分类页面的菜单栏
	@RequestMapping(value="/nav",method=RequestMethod.GET)
	@ResponseBody
	public List<com.iread.beans.domain.Class> booksNavList(){
		return nav.getBookNavs();
	}
	
	//判断是否移动端
	@RequestMapping("books")
	public String books(HttpServletRequest request){
		String userAgent = request.getHeader( "USER-AGENT" );  
		boolean b = DeviceUtil.DEVICE_UTIL.isMobileDevice(userAgent);
		System.out.println(b);
		System.out.println(userAgent);
		return "books";
	}
	
}
