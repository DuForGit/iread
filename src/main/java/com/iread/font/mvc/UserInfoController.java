package com.iread.font.mvc;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.iread.beans.domain.MyBookDo;
import com.iread.beans.domain.UserInfomations;
import com.iread.font.service.UserService;
import com.iread.utils.SessionKey;

/**
 *项目名称: iread
 *类名称: UserInfoController
 *类描述: 关于用户信息的一些基本处理
 *创建人: Administrator
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Controller
public class UserInfoController {
	
	@Autowired
	private UserService user;
	
	//个人主页
	@RequestMapping("/my")
	public String showMe(HttpServletRequest request,Model model){
		int userId = (int) request.getSession().getAttribute(SessionKey.USER_ID);
		model.addAttribute("info",user.getMyInfos(userId));
		return "my";
	}
	//上传图片
	@RequestMapping(value="upload",method=RequestMethod.POST)
	public String loadImg(){
		System.out.println("load");
		return "redirect:/my";
	}
	
	//个人信息
	@RequestMapping("/myinfos")
	public String showMeInfos(HttpServletRequest request, Model model){
		int userId = (int) request.getSession().getAttribute(SessionKey.USER_ID);
		model.addAttribute("info",user.getMyInfos(userId));
		System.out.println("info:" + user.getMyInfos(userId));
		return "myinfo";
	}
	
	//设置--设置页面
	@RequestMapping("/set")
	public String set(HttpServletRequest request, Model model){
		int userId = (int) request.getSession().getAttribute(SessionKey.USER_ID);
		model.addAttribute(user.getMyInfos(userId));
		//System.out.println("aboutme:" + user.getMyInfos(userId));
		return "set";
	}
	//设置--设置设个人信息
	@RequestMapping("/setinfo")
	public void setInfo(HttpServletRequest request, UserInfomations infos){
		
		user.setMyInfos(infos);
		//return "redirect:/myinfo";
	}
	//设置--重设个人信息
	@RequestMapping(value="/reset",method=RequestMethod.POST)
	public void reset(HttpServletRequest request, UserInfomations infos){
		user.changeMyInfos(infos);
		System.out.println("infos :: " + infos);
		//return "redirect:/myinfo";
	}
	
	//购物车
	@RequestMapping("/mycart")
	public String cart(HttpServletRequest request, Model model,
			@RequestParam(value="p",required=false,defaultValue="1") int page){
		int userId = (int) request.getSession().getAttribute(SessionKey.USER_ID);
		model.addAllAttributes(user.getMyCarts(userId, page));
		return "cart";
	}
	//ID为books id
	@RequestMapping("addcart")
	public String addMyCart(HttpServletRequest request, int id){
		int userId = (int) request.getSession().getAttribute(SessionKey.USER_ID);
		user.addBookToMyCart(id, userId);
		return "redirect:/ebook?id="+id;
		}
	//ID为cart表ID
	/*@RequestMapping("delcart")
	public String delMyCart(HttpServletRequest request, int id){
		int userId = (int) request.getSession().getAttribute(SessionKey.USER_ID);
		user.moveBookFromMyCart(userId,id);
		return "redirect:/my";}*/
	@RequestMapping(value="delcart",method=RequestMethod.POST)
	public void delMyCart(HttpServletRequest request, int id){
		int userId = (int) request.getSession().getAttribute(SessionKey.USER_ID);
		user.moveBookFromMyCart(userId,id);
		}
	
	
	//订单
	@RequestMapping("/myorder")
	public String order(HttpServletRequest request, Model model){
		int userId = (int) request.getSession().getAttribute(SessionKey.USER_ID);
		model.addAttribute("orders", user.getMyOrders(userId));
		return "order";
	}
	
	//书架
	@RequestMapping("/mybooks")
	public String myBooks(HttpServletRequest request, Model model,
			@RequestParam(value="p", defaultValue="1",required=false) int page){
		int userId = (int) request.getSession().getAttribute(SessionKey.USER_ID);
		model.addAttribute("page", user.getMyBooks(userId, page));
		return "mybooks";
	}
	//id表示mybooks的主键
	@RequestMapping(value="/addmybook",method=RequestMethod.GET)
	public String addMyBook(HttpServletRequest request,int id){
		int uId = (int) request.getSession().getAttribute(SessionKey.USER_ID);
		MyBookDo my = new MyBookDo();
		my.setBookId(id);
		my.setUserId(uId);
		user.addMyBook(my);
		return "redirect:/ebook?id="+id;
	}
	//删除书架上的数据，id为书架books表上的主键
	/*@RequestMapping("/delmybook")
	public String deleteMyBook(HttpServletRequest request,int id){
		int uId = (int) request.getSession().getAttribute(SessionKey.USER_ID);
		int myId = user.getMybookId(uId, id);
		user.deleteMyBook(myId);
		return "redirect:/my";
	}*/
	@RequestMapping(value="/delmybook",method=RequestMethod.POST)
	public void deleteMyBook(HttpServletRequest request,int id){
		int uId = (int) request.getSession().getAttribute(SessionKey.USER_ID);
		int myId = user.getMybookId(uId, id);
		user.deleteMyBook(myId);
	}
	
	@RequestMapping(value="buy",method=RequestMethod.POST)
	@ResponseBody
	public int buyBook(HttpServletRequest request, int bid){
		System.out.println("控制层：不用通过支付宝支付");
		int uid = (int) request.getSession().getAttribute(SessionKey.USER_ID);
		int flag = user.buyBook(bid, uid);//购买状态
		/*if(flag == 1){
			return "redirect:/ebook?id=" + bid;
		}else{
			return null;
		}*/
		System.out.println("flag:" + flag);
		return flag;
	}
	
	@RequestMapping(value="ispay",method=RequestMethod.POST)
	@ResponseBody
	public String isPay(HttpServletRequest request, int bid){
		int uid = (int) request.getSession().getAttribute(SessionKey.USER_ID);
		boolean ispay= user.isPay(bid, uid);
		if(ispay){
			return "1";
		}
		else{
			return "forward:pay";
		}
	}
	
	@RequestMapping(value="pay",method=RequestMethod.POST)
	@ResponseBody
	public void alipay(HttpServletRequest request, int bid,HttpServletResponse httpResponse) throws Exception{
		System.out.println("控制层：支付宝支付");
		int uid = (int) request.getSession().getAttribute(SessionKey.USER_ID);
		String flag = user.alipay(bid, uid,request);
		System.out.println("返回：" + flag);
		
		
		httpResponse.setContentType("text/html;charset=utf-8");
	    httpResponse.getWriter().write(flag);//直接将完整的表单html输出到页面
	    httpResponse.getWriter().flush();
	    httpResponse.getWriter().close();
		
		
		//return flag;
		
	}
	
	@RequestMapping(value="return",method=RequestMethod.GET)
	public String return_url(HttpServletRequest request){
		boolean success = false;
		try {
			success = user.payReturnurl(request);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		if(success){
			String out_trade_no = request.getParameter("out_trade_no");
			int bid  = Integer.valueOf(out_trade_no.substring(out_trade_no.length()-6,out_trade_no.length()-1));
			return "redirect:ebook?id=" + bid;
		}
		return "feedback";
	}
	
	
	//退出
	@RequestMapping("/quit")
	public String quit(HttpServletRequest request){
		request.getSession().removeAttribute(SessionKey.USER_ID);
		return "redirect:/index";
	}
	
	@RequestMapping("feedback")
	public String feedback(){
		return "feedback";
	}
	
	
	
/*	//问题反馈
	@RequestMapping("/problem")
	public String setProblem(HttpServletRequest request, Model model){
		return "set";
	}*/
	
/*	//信息
	@RequestMapping("/news")
	public String showNews(HttpServletRequest request, Model model){
		return "news";
	}*/
	
	
	
/*	//账号设置--操作页面
	@RequestMapping("/accntset")
	public String accountSet(HttpServletRequest request, Model model){
		return "accountsettings";
	}
	//账号设置--更改密码
	@RequestMapping("/changePass")
	public String changePass(HttpServletRequest request, Model model){
		return "accountsettings";
	}*/
	
}
