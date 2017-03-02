package com.ankit.cartbackend.testcase;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ankit.cartbackend.dao.CategoryDAO;
import com.ankit.cartbackend.model.Category;

import junit.framework.Assert;

public class CategoryTestCase {
	
	@Autowired
	private static Category category;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void init()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
		context.scan("com.ankit");
		context.refresh();
		
		category = (Category) context.getBean("category");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
	}
	
         //testcase
	
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void createCategoryTestCase()
	{
		category.setId("CG02032017");
		category.setName("Accessories Category");
		category.setDescription("this is Accessories category");
		
		boolean flag = categoryDAO.save(category);
		//compare what you are expecting vs what you are getting from save method.
		
		Assert.assertEquals("create categoryTestCase",true, flag);
		
/*		Assert.assertEquals("create categoryTestCase" ,true, flag);*/
	
	}
	@Test
	public void updateCategoryTestCase()
	{
		
		category.setId("CG02032017");
		category.setName("new Category");
		category.setDescription("this is men category");
		
		boolean flag= categoryDAO.update(category);
		
		Assert.assertEquals("updateCategoryTestCase", true, flag);
		
		
	}
	public void deleteCategoryTestCase()
	{
		
		boolean flag = categoryDAO.delete("CG02032017");
		
	}
	
		
		 
		
	
	
		
		
		
	

}
