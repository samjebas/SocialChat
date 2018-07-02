package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;
import com.niit.model.BlogComment;

public class BlogDAOimpl implements BlogDAO {
	
	
	@Autowired
	SessionFactory sessionfactory;

	public boolean addBlog(Blog blog) {
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

	public boolean deleteBlog(Blog blog) {
		try {
			sessionfactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean updateBlog(Blog blog) {
		try {
			sessionfactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean approveBlog(Blog blog) {
		try {
			blog.setStatus("A");
			sessionfactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean rejectBlog(Blog blog) {
		try {
			blog.setStatus("NA");
			sessionfactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public BlogComment getBlog(int commentId) {
		try {
			Session session = sessionfactory.openSession();
			BlogComment blogComment = session.get(BlogComment.class,commentId);
			return blogComment;
		} catch (Exception e) {
			return null;
		}
	}

	public List<BlogComment> listBlog(int blogId) {
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from BlogComment where blogId=:blogId");
		query.setParameter("blogId", new Integer(blogId));
		@SuppressWarnings("unchecked")
		List<BlogComment> listBlogComments=query.list();
		return listBlogComments;
	}

	public boolean incrementLikes(Blog blog) {
		 try{
			 int likes=blog.getLikes();
			 likes++;
			 blog.setLikes(likes);
			 sessionfactory.getCurrentSession().update(blog);
			 return true;
		 }catch(Exception e)
		 {
			 return false;
		 }
	}

	public boolean disLikes(Blog blog) {
		try{
			 int likes=blog.getLikes();
			 likes--;
			 blog.setLikes(likes);
			 sessionfactory.getCurrentSession().update(blog);
			 return true;
		 }catch(Exception e)
		 {
			 return false;
		 }
	}

}
