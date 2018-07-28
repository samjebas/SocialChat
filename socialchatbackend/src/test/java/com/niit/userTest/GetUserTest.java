package com.niit.userTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDetailDAO;
import com.niit.model.UserDetail;

public class GetUserTest {

	private static UserDetailDAO userdao;
	private UserDetail user;

	@BeforeClass
	public void intialise() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userdao = (UserDetailDAO) context.getBean("UserDAO");

	}

	@Ignore
	@Test
	public void getUserNameTest() {
		
		user = userdao.getUser("Sam") ;
		assertEquals("Successfully fetched  the username   from the Table", "Samuel Jebastin",user.getUserName());
		System.out.println("---------------Fetched username Successfully------------");

	}
}
