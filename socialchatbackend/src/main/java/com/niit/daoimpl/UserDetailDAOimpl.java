package com.niit.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.UserDetailDAO;
import com.niit.model.UserDetail;

public class UserDetailDAOimpl implements UserDetailDAO {

	@Autowired
	SessionFactory sessionfactory;

	public boolean registerUser(UserDetail userdetail) {

		try {
			sessionfactory.getCurrentSession().save(userdetail);
			return true;

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		}

	}

	@SuppressWarnings("deprecation")
	public boolean checkLogin(UserDetail userdetail) {

		try {
			Session session = sessionfactory.openSession();
			Query query = session.createQuery("from UserDetail where loginname=:loginname and password=:password");
			query.setParameter("loginname", userdetail.getLoginname());
			query.setParameter("password", userdetail.getPassword());
			UserDetail userDetails = (UserDetail) query.list().get(0);
			session.close();
			if (userDetails == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public UserDetail getUser(String loginname) {

		Session session = sessionfactory.openSession();
		UserDetail userDetail =(UserDetail)session.get(UserDetail.class,loginname);
		session.close();
		return userDetail;

	}

	public boolean updateUser(UserDetail user) {
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(user);
			return true;

		} catch (HibernateException e) {

			e.printStackTrace();

			return false;
		}
	}

	public boolean deleteuser(UserDetail user) {
		try {
			sessionfactory.getCurrentSession().delete(user);

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<UserDetail> listUsers() {
		try {
			Session session = sessionfactory.openSession();
			session.beginTransaction();
			List<UserDetail> userList = new ArrayList<UserDetail>();
			Query query = session.createQuery("FROM UserDetail");
			userList = query.list();
			return userList;
		} catch (Exception e) {
			return null;
		}
	}

}
