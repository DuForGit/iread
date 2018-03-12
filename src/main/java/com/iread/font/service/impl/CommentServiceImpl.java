package com.iread.font.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iread.beans.domain.Comment;
import com.iread.font.dao.CommentMapper;
import com.iread.font.service.CommentService;
import com.iread.utils.PageUtil;

/**
 *项目名称: iread
 *类名称: CommentServiceImpl
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年3月9日下午11:11:15
 * @version
 * @author 方秋都
 *
 */
@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentMapper comment;
	/* (non-Javadoc)
	 * @see com.iread.font.service.CommentService#addComment(int, int, java.lang.String)
	 */
	@Override
	public void addComment(int uid, int bid, String com) {
		comment.addComment(uid, bid, com);
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.CommentService#getComments(int,int)
	 */
	@Override
	public Map<String,Object> getComments(int bid,int page) {
		PageUtil.startPage(page);
		return PageUtil.pageInfos(comment.getComments(bid));
	}

}
