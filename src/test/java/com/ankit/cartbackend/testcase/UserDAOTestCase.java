package com.ankit.cartbackend.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ankit.cartbackend.dao.UserDAO;
import com.ankit.cartbackend.model.User;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class UserDAOTestCase {

	//Autowire - DAO, DO, context
	
	
	@Autowired
	private static UserDAO userDAO;
	
	@Autowired
	private static User  user;
	
	@Autowired
  private static AnnotationConfigApplicationContext context;
	
	
	//Previously we written constructor
	//But in Junit we need to write a method
	//this method should call automatically when JUnit Test case run
	 //we can write @BeforeClasses only for the static methods
	@BeforeClass 
	public static void initialize()
	{
		context = new  AnnotationConfigApplicationContext();
		context.scan("com.ankit.cartbackend");
		context.refresh();
		
        user = (User) context.getBean("user");
		
		userDAO = (UserDAO) context.getBean("userDAO");
		
	}
                                            //USER VALIDATION
	
@Test 
public void validateCredentialsTestCase()	{
		
boolean flag = userDAO.validate("ankit","ankit");

Assert.assertEquals("validateCredentialTestCase" ,true, flag);
}
	
	                                       //USER_INSERT
	@Test
	public void TestCreateUser()
	{
		user.setId("128");
		user.setName("akash");
		user.setPassword("akash123");
		user.setMail("akash@123");
		user.setContact("426212312");
		user.setRole("ROLE_USER");
		
		
		boolean flag = userDAO.save(user);
		Assert.assertEquals("create categoryTestCase",true, flag);
		
	}
	                                        // USER_UPDATE
	@Test
	public void updateUserTestCase()
	{
		
		user.setId("123");
		user.setName("ankit");
		user.setPassword("ankit123");
		user.setMail("ankit@123");
		user.setContact("8527737120");
		user.setRole("ROLE_USER");
		boolean flag= userDAO.update(user);
		
		Assert.assertEquals("updateUserTestCase", true, flag);
		
	
}
	@Test
	public void deleteUserTestCase()
	{
		
		
		boolean flag = userDAO.delete("125");
		
		Assert.assertEquals("deleteUserTestCase",true, flag);
		
		
	}	
	
		
	}	

	