package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.BlogCommentDAO;
import com.niit.model.BlogComment;

public class BlogCommentDAOimpl implements BlogCommentDAO {

	@Autowired
	SessionFactory sessionfactory;

	public boolean addBlogComment(BlogComment blogComment) {
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(blogComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean removeBlogComment(BlogComment blogComment) {
		try {
			sessionfactory.getCurrentSession().delete(blogComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public BlogComment getBlogComment(int commentId) {
		try {
			Session session = sessionfactory.openSession();
			BlogComment blogComment = session.get(BlogComment.class,commentId);
			return blogComment;
		} catch (Exception e) {
			return null;
		}	
	}

	public List<BlogComment> listBlogComment(int blogId) {
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from BlogComment where blogId=:blogId");
		query.setParameter("blogId", new Integer(blogId));
		@SuppressWarnings("unchecked")
		List<BlogComment> listBlogComments=query.list();
		return listBlogComments;
	}

}
