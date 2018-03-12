package com.iread.font.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iread.beans.domain.Comment;

/**
 *项目名称: iread
 *类名称: CommentMapper
 *类描述: 评论
 * @author 方秋都
 *
 */
public interface CommentMapper {
	void addComment(@Param("uid") int uid,@Param("bid") int bid,@Param("comment") String com);
	List<Comment> getComments(@Param("bid") int bid);
}
