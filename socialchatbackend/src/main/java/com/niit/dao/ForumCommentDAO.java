package com.niit.dao;

import java.util.List;

import com.niit.model.Forum;
import com.niit.model.ForumComment;

public interface ForumCommentDAO {
	
	
	
	public boolean addForumComment(Forum forumComment);
	public boolean deleteForumComment(Forum forumComment);
	public ForumComment getForumComment(int commentId);
	public List<ForumComment> listForumComments(int forumId);

}
