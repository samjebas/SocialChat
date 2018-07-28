package com.niit.userTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDetailDAO;
import com.niit.model.UserDetail;

public class UpdateUserTest {
	
	
	private static UserDetailDAO userdao;
	private UserDetail user;

	@BeforeClass
	public static void intialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userdao = (UserDetailDAO) context.getBean("userDAO");
	}
	
	@Test
	public void updateUserTest() {
		UserDetail user = new UserDetail();
		user = userdao.getUser("Sam");
		user.setUserName("Sam Jebastin");
		assertEquals("Successfully Updated User into the table",true,userdao.updateUser(user));
		System.out.println("---------Successfully Updated User------------");
		
	}

}
