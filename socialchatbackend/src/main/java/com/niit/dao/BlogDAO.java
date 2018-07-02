package com.niit.dao;

import java.util.List;

import com.niit.model.Blog;
import com.niit.model.BlogComment;

public interface BlogDAO {
	
	
	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean approveBlog(Blog blog);
	public boolean rejectBlog(Blog blog);
	public BlogComment getBlog(int commentId);
	public List<BlogComment> listBlog(int blogiId);
	public boolean incrementLikes(Blog blog);
	public boolean disLikes(Blog blog);

}
