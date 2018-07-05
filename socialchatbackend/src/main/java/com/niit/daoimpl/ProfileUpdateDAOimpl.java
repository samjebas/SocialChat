package com.niit.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.ProfileUpdateDAO;
import com.niit.model.Profile;

public class ProfileUpdateDAOimpl implements ProfileUpdateDAO {

	@Autowired SessionFactory sessionfactory;
	
	
	public void saveProfilePic(Profile profilePicture) {
		System.out.println("Profile LoginName:" +profilePicture.getLoginname());
	Session session = sessionfactory.openSession();
	session.save(profilePicture);
	session.flush();
	session.close();
		
	}

	public Profile getProfilePicture(String loginname) {
		Session session = sessionfactory.openSession();
		Profile profile=session.get(Profile.class, loginname);
		session.close();
		return profile;
	}

}
