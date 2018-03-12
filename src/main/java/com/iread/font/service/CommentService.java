package com.iread.font.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iread.beans.domain.Comment;

/**
 *项目名称: iread
 *类名称: CommentService
 *类描述: 评论
 * @author 方秋都
 *
 */
public interface CommentService {
	void addComment( int uid, int bid, String com);
	Map<String,Object> getComments(int bid,int page);
}
