package com.niit.userTest;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDetailDAO;
import com.niit.model.UserDetail;

public class UserDAOTest {
	private static UserDetailDAO userDetailDAO;

	@BeforeClass
	void intialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDetailDAO = (UserDetailDAO) context.getBean("UserDAO");
		
	}

	
	@Test
	void registerUser() {
		UserDetail userDetail = new UserDetail();
		userDetail.setLoginName("Sam");
		userDetail.setPassword("sam@123");
		userDetail.setRole("ADMIN");
		userDetail.setUserName("Samuel Jebastin");
		userDetail.setEmailid("samjebastin77@gmail.com");
		userDetail.setAddress("Bhiwandi");
		userDetail.setMobileNo("9766376624");
		userDetail.setIsOnline("N");
		assertTrue("Problem in Registering User", userDetailDAO.registerUser(userDetail));
		System.out.println("-----------------------Sucessfully UserDetails is Registered------------------");
	}

	@Ignore
	@Test
	public void updateIsOnLineTest() {
		UserDetail userDetail = userDetailDAO.getUser("Sam");
		assertTrue("Problem in Updating Status", userDetailDAO.updateOnlineStatus("O", userDetail));
		System.out.println("----------------------Successfully Updated User is Online----------------------");

	}

	@Ignore
	@Test
	public void checkUserTest() {
		UserDetail userDetail = new UserDetail();
		userDetail.setLoginName("Sam");
		userDetail.setPassword("sam@123");
		assertTrue("Problem in Checking User Test Case", userDetailDAO.checkLogin(userDetail));
		System.out.println("Checked User Successfully");
	}

}