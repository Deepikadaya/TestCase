package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;
import com.niit.model.User;


public class UserUnitTest {
	static UserDAO userDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}

	@Test
	public void addUserTest()
	{
		User user=new User();
		user.setUserId(1);
		user.setCustomerName("Deepika");
		user.setMobileNo("9988664422");
		user.setAddress("Chennai");
		user.setPassword("deepika");
		user.setUserName("Admin");
		user.setEmail("admin@google.com");
		assertTrue("Problem in User Insertion",userDAO.addUser(user));
	}
    
	@Test
	public void updateUserTest()
	{
		User user=userDAO.getUser(1);
	    user.setUserName("The Admin");
		assertTrue("Problem in Updation",userDAO.updateUser(user));
	}
	
	@Test
	public void listUserTest()
	{
		List<User> listUser=userDAO.getUser();
		assertNotNull("No User",listUser);
		
		for(User user:listUser)
		{
			System.out.print(user.getUserName()+":::");
			System.out.print(user.getEmail()+":::");
			
		}
	}



}
