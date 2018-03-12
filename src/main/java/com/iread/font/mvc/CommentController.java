package com.iread.font.mvc;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iread.font.service.CommentService;
import com.iread.utils.SessionKey;

/**
 *项目名称: iread
 *类名称: CommentController
 *类描述: 评论
 * @author 方秋都
 *
 */
@Controller
public class CommentController {
	@Autowired
	private CommentService comments;
	
	@RequestMapping(value="/addcomment",method=RequestMethod.POST)
	@ResponseBody
	public boolean addComment(HttpServletRequest request, String comment,int bid){
		int uid = (int) request.getSession().getAttribute(SessionKey.USER_ID);
		System.out.println("comment：" + comment + "； bid：" + bid);
		comments.addComment(uid, bid, comment);
		return true;
	}
	
	@RequestMapping(value="/getcomms")
	@ResponseBody
	public Map<String,Object> getComments(int page,int bid){
		return comments.getComments(bid, page);
	}
}
