package com.niit.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.ForumCommentDAO;
import com.niit.model.Forum;
import com.niit.model.ForumComment;

public class ForumCommentDAOimpl implements ForumCommentDAO {

	@Autowired SessionFactory sessionfactory;
	
	public boolean addForumComment(Forum forumComment) {
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(forumComment);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteForumComment(Forum forumComment) {
		try {
			sessionfactory.getCurrentSession().delete(forumComment);
			return true;
		} catch (HibernateException e) {
		
			e.printStackTrace();
			return false;
		}
		
	}

	public ForumComment getForumComment(int commentId) {
		try {
			Session session = sessionfactory.openSession();
			ForumComment forumComment = session.get(ForumComment.class, commentId);
			return forumComment;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public List<ForumComment> listForumComments(int forumId) {
		try {
			Session session = sessionfactory.openSession();
			Query query =session.createQuery("from ForumComment where forumId=:forumId");
			query.setParameter("forumId", new Integer (forumId));
			List<ForumComment> forumCommentList = query.list();
			return forumCommentList;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
