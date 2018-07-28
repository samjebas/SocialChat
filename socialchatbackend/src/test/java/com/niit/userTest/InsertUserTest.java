package com.niit.userTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDetailDAO;
import com.niit.model.UserDetail;

public class InsertUserTest {
	
	private static UserDetailDAO userdao;
	private UserDetail user;

	@Test
	public void intialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userdao = (UserDetailDAO) context.getBean("UserDAO");
		
		
	}

	@Test
	public void insertUserTest() {
		
		UserDetail user = new UserDetail();
		user.setUserName("Prabhat");
		user.setEmailid("Prabhat@gmail.com");
		user.setPassword("prabhat@123");
		user.setRole("USER");
		assertEquals("Successfully added User into the Table", true , userdao.registerUser(user));
		System.out.println("---------------Successfully Inserted into User----------------");
	}
}
