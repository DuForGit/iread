package com.iread.font.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.iread.beans.domain.AIIAboutMe;
import com.iread.beans.domain.AlipayOrder;
import com.iread.beans.domain.Book;
import com.iread.beans.domain.MyBookDo;
import com.iread.beans.domain.Order;
import com.iread.beans.domain.UserInfomations;
import com.iread.font.dao.BooksListMapper;
import com.iread.font.dao.UserMapper;
import com.iread.font.service.UserService;
import com.iread.utils.AlipayConfig;
import com.iread.utils.OrderUtil;
import com.iread.utils.PageUtil;
import com.iread.utils.SessionKey;

/**
 *项目名称: iread
 *类名称: UserServiceImpl
 *类描述: UserService的具体实现
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper user;
	@Autowired
	private BooksListMapper books;

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#getMyBooks(int)
	 */
	@Override
	public Map<String, Object> getMyBooks(int userId,int page) {
		List<Book> bs = null;
		List<Integer> bookIds = user.getBookIdsByUserId(userId);
		if(bookIds != null && !bookIds.isEmpty()){
			//PageUtil.startPage(page);
			bs = books.getBookByIds(bookIds);
		}
		if(bs != null && !bs.isEmpty()){
			return PageUtil.pageInfos(bs);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#getMyCarts(int)
	 */
	@Override
	public Map<String, Object> getMyCarts(int userId,int page) {
		//PageUtil.startPage(page);
		List<Integer> ids = user.BookIdsOfMyCart(userId);
		
		List<Book> bs = null;
		if(ids != null && !ids.isEmpty()){
			//PageUtil.startPage(page);
			bs = user.getMyCart(ids);
		}
		if(bs != null && !bs.isEmpty()){
			return PageUtil.pageInfos(bs);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#getMyOrders(int)
	 */
	@Override
	public List<Order> getMyOrders(int userId) {
		System.out.println(user.getOrderBookIdsByUserId(userId));
		return user.getOrderBookIdsByUserId(userId);
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#getnews(int)
	 */
	@Override
	public Map<String, Object> getnews(int userId) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#getMyInfos(int)
	 */
	@Override
	public AIIAboutMe getMyInfos(int userId) {
		AIIAboutMe all = new AIIAboutMe();
		all.setUser(user.getMyAllInfos(userId));
		all.setBooks(user.getRecentReadingBooks(userId));
		return all;
	}

	@Override
	public void setMyInfos(UserInfomations info) {
		user.setMyInfos(info);
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#changeMyInfos(com.iread.beans.domain.UserInfomations)
	 */
	@Override
	public void changeMyInfos(UserInfomations info) {
		if(user.isExistInfo(info.getId()) != 0){
			user.changeMyInfos(info);
		}else{
			if(info.getGender().contains("未知")){
				info.setGender("未知");
			}
			user.setMyInfos(info);
		}
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#changePass(int, java.lang.String)
	 */
	@Override
	public boolean changePass(String email, String newPass) {
		Integer success = user.resetPassword(newPass, email);
		if(success != null){
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#addMyBook(com.iread.beans.domain.MyBookDo)
	 */
	@Override
	public void addMyBook(MyBookDo book) {
		if(user.hasOrder(book.getBookId(), book.getUserId()) != null){
			book.setPayment(true);
		}
		user.addMyBook(book);
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#deleteMyBook(int)
	 */
	@Override
	public void deleteMyBook(int id) {
		user.deleteMyBook(id);
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#addBookToMyCart(int, int)
	 */
	@Override
	public boolean addBookToMyCart(int bookId,int userId) {
		System.out.println("购物车数量："+user.numOfMyCart(userId));
		if(user.numOfMyCart(userId) >= 99){
			return false;
		}
		
		if(user.addBookToMyCart(userId, bookId) == 0)return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#moveBookFromMyCart(int)
	 */
	@Override
	public void moveBookFromMyCart(int uid , int bid) {
		
		user.deleteMyCart(user.getCartId(uid, bid));
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#getMybookId(int, int)
	 */
	@Override
	public int getMybookId(int uId, int bId) {
		return user.getMybookId(uId, bId);
	}


	@Override
	//0:表示已经购买,1:表示商品下架,2:表示购买成功,3:表示购买失败
	//不经过支付宝的购买，只支持价格为0的图书
	public int buyBook(int bid,int uid) {
		System.out.println("业务层：不通过支付宝支付");
		float price = user.isFree(bid);
		System.out.println("buyBook::price:: "+price);
		Integer buy = user.isBuyBook(bid, uid);//是否购买该书
		if(buy == null){//表示未加入书架
			if(ifSoldout(bid)){//未下架，可以购买
				if(price == 0){	
					if(user.hasOrder(bid, uid) == null){
						user.addBook(bid, uid);//添加书架
						user.addOrder(bid, uid, 0,"","");//添加订单
						user.addOne(bid);//添加购买量
					}else{
						System.out.println("no-alipay:表示书架上没有该书，但订单上有该书");
						MyBookDo book = new MyBookDo();
						book.setBookId(bid);
						book.setUserId(uid);
						book.setPayment(true);
						user.addMyBook(book);//添加书架
						return 0;
					}
					
					
				}else{
					return 3;
				}
				
			}else{//已下架，不可购买
				return 1;
			}
		}else{//表示已加入书架
			if(buy == 1){//表示已经购买
				return 0;
			}else{//表示未购买
				if(ifSoldout(bid)){
					if(price == 0){	
						if(user.hasOrder(bid, uid) == null){
							user.addBook(bid, uid);//添加书架
							user.addOrder(bid, uid, 0,"","");//添加订单
							user.addOne(bid);//添加购买量
						}else{
							System.out.println("no-alipay:表示书架上没有该书，但订单上有该书");
							MyBookDo book = new MyBookDo();
							book.setBookId(bid);
							book.setUserId(uid);
							book.setPayment(true);
							user.addMyBook(book);//添加书架
							return 0;
						}	
					}else{
						return 3;
					}
					
					
					/*user.buyBook(bid, uid);//修改是否该买该书的字段
					user.addOrder(bid, uid, user.getPrice(bid),"","");//添加订单
					user.addOne(bid);//添加购买量
*/				}else{
					return 1;
				}
				
			}
		}
		return 2;
		
		
		/*if(buy == 1){//已购买
			return 0;
		}else{
			Date date = user.getSoldout(bid);
			System.out.println("Date: " + date);
			if(date.before(new Date())){//未下架
				if(buy == null){//未存放在书架上
					user.addBook(bid, uid);//添加书架
				}else{
					user.buyBook(bid, uid);//修改是否该买该书的字段
				}
			}else{
				return 2;
			}
			return 1;
		}*/
		
		
		/*Integer buy = user.isBuyBook(bid, uid);
		if(buy == null){
			user.addBook(bid, uid);
		}else{
			if(buy.intValue() == 0){
				user.buyBook(bid, uid);
			}
		}
		//user.deleteCartBook(bid, uid);
		
		user.addOrder(bid, uid, user.getPrice(bid));
		user.addOne(bid);*/

	}
	
	private boolean ifSoldout(int bid){//判断是否已下架
		Date date = user.getSoldout(bid);
		System.out.println("Date: " + date);
		System.out.println(date.before(new Date()));
		return date.after(new Date());
	}


	@Override
	public String alipay(int bid, int uid,HttpServletRequest request) throws Exception {
		System.out.println("业务层：支付宝支付");
		//1.判断是否存在书架上; 2.是否已购买
		Integer buy = user.isBuyBook(bid, uid);//是否购买该书--mybooks表
		Integer hasOrder = user.hasOrder(bid, uid);//orders表
		
		boolean buy_flag = false;//是否购买
		int in_mybooks_falg = 0;//是否已在书架上,0表示没有，1表示有，此表情要加入到订单编号的尾部位置
		if(buy != null){
			in_mybooks_falg = 1;
			if(buy == 1){buy_flag = true;}
		}
		
		//System.out.println("是否已购买："+ buy_flag);
		if(buy_flag){//表示已购买
			return "0";//表示已购买
		}else{
			
			if(hasOrder != null && in_mybooks_falg == 0){//表示书架上没有该书，但订单上有该书
				System.out.println("alipay:表示书架上没有该书，但订单上有该书");
				MyBookDo book = new MyBookDo();
				book.setBookId(bid);
				book.setUserId(uid);
				book.setPayment(true);
				user.addMyBook(book);
				return "0";
			}
			
			if(ifSoldout(bid)){//判断是否下架
				//获取图书信息
				AlipayOrder alipayOrder = user.getAlipayOrder(bid);
				
				AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
				 AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
				 alipayRequest.setReturnUrl(AlipayConfig.return_url);
				 alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
				 //商户订单号，商户网站订单系统中唯一订单号，必填
					String out_trade_no = OrderUtil.getInstance().bookOrder(bid, uid) + in_mybooks_falg;
					//付款金额，必填
					float total_amount = alipayOrder.getPrice();
					//订单名称，必填
					String subject = alipayOrder.getTitle() + " (" + alipayOrder.getWriter() + " / " + alipayOrder.getPublish() + ")";
					//String subject =sub;// new String(sub.getBytes("UTF-8"),"UTF-8");//alipayOrder.getTitle() + " (" + alipayOrder.getWriter() + " / " + alipayOrder.getPublish() + ")";
					//商品描述，可空
					String body =  alipayOrder.getTitle() + " - " + alipayOrder.getWriter() + " - " + alipayOrder.getPublish() + " - " + alipayOrder.getPrice() + " - " + out_trade_no;
					
					System.out.println("alipayOrder: " + alipayOrder);
					System.out.println("total_amount: " + total_amount);
					System.out.println("body: " + body);
					System.out.println("out_trade_no: " + out_trade_no);
					System.out.println("subject: "+ subject);
					
					String bizContent ="{\"out_trade_no\":\""+ out_trade_no +"\"," 
							+ "\"total_amount\":\""+ total_amount +"\"," 
							+ "\"subject\":\""+ subject +"\"," 
							+ "\"body\":\""+ body +"\"," 
							+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}";
					alipayRequest.setBizContent(bizContent);
					System.out.println("bizContent: "  + bizContent);
					String result = "";
					result = alipayClient.pageExecute(alipayRequest).getBody();
					return result;			
			}else{return "1";}//表示已下架；0表示已购买，1表示下架，符合购买条件返回支付宝支付页面	
		}
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.UserService#isPay(int, int)
	 */
	@Override
	public boolean isPay(int bid, int uid) {
		Integer isbuy = user.isBuyBook(bid, uid);
		if(isbuy !=null && isbuy != 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean payReturnurl(HttpServletRequest request) throws AlipayApiException {	
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			params.put(name, valueStr);
		}
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
		if(signVerified) {
			String out_trade_no =request.getParameter("out_trade_no");//订单号
			String trade_no = request.getParameter("trade_no");//支付宝交易号
			String total_amount = request.getParameter("total_amount");//交易金额
			
			
			System.out.println("订单号: "+out_trade_no);
			System.out.println("支付宝交易号: " + trade_no);
			System.out.println("total_amount: " + total_amount);
			
			int uid = (int) request.getSession().getAttribute(SessionKey.USER_ID);
			int bid  = Integer.valueOf(out_trade_no.substring(out_trade_no.length()-6,out_trade_no.length()-1));
			int in_mybooks_falg = Integer.valueOf(out_trade_no.substring(out_trade_no.length()-1, out_trade_no.length()));//是否已在书架上
			System.out.println("return: uid: " +uid + "; bid" + bid + "; in_mybooks_falg: " + in_mybooks_falg);
			if(in_mybooks_falg == 0){
				user.addBook(bid, uid);//添加书架
			}else{
				user.buyBook(bid, uid);//修改是否该买该书的字段
			}
			user.addOrder(bid, uid, Float.valueOf(total_amount),out_trade_no,trade_no);//添加订单
			user.addOne(bid);//添加购买量
			return true;
		}
		return false;
	}

}
