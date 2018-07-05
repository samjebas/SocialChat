package com.niit.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.ForumDAO;
import com.niit.model.Forum;

public class ForumDAOimpl implements ForumDAO {

	@Autowired
	SessionFactory sessionfactory;

	public boolean addForum(Forum forum) {
		try {
			sessionfactory.getCurrentSession().save(forum);

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteForum(Forum forum) {
		try {
			sessionfactory.getCurrentSession().delete(forum);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean updateForum(Forum forum) {
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean approveForum(Forum forum) {
		forum.setStatus("A");
		try {
			sessionfactory.getCurrentSession().update(forum);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean rejectForum(Forum forum) {
		forum.setStatus("NA");
		try {
			sessionfactory.getCurrentSession().update(forum);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Forum getForum(int forumId) {
		try {
			Session session = sessionfactory.openSession();
			Forum forum = session.get(Forum.class, forumId);
			return forum;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public List<Forum> listForum(int forumId) {
	Session session =	sessionfactory.openSession();
	Query query = session.createQuery("from Forum");
	query.setParameter(forumId, new Integer(forumId));
	
	List<Forum>  forumList = query.list();
	return forumList;
	
	}

}
