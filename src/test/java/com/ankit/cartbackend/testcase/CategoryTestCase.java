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
		category.setId("CG02052017");
		category.setName("Android Category");
		category.setDescription("this is Android category");
		
		boolean flag = categoryDAO.save(category);
		//compare what you are expecting vs what you are getting from save method.
		
		Assert.assertEquals("create categoryTestCase",true, flag);
		
/*		Assert.assertEquals("create categoryTestCase" ,true, flag);*/
	
	}
	@Test
	public void updateCategoryTestCase()
	{
		
		category.setId("CG02042017");
		category.setName("window");                        //size of the field
		category.setDescription("this is window category");
		
		boolean flag= categoryDAO.update(category);
		
		Assert.assertEquals("updateCategoryTestCase", true, flag);
		
		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void deleteCategoryTestCase()
	{
		
		
		boolean flag = categoryDAO.delete("CG02052017");
		
		Assert.assertEquals("delete CategoryTestCase",true, flag);
		
		
	}	
	@Test
	@SuppressWarnings("deprecation")
	public void getCategoryByIDTestCase()
	{
	category = categoryDAO.getCategoryByID("CG02052017");
	
	//if you want to retrive data by record id
	//int recordFromDAO = catgoryDAO.list().size();
	//assertEquals("getAllCategoriesTestCase" ,7, recordsFromDAO);
	
	
	//Assert.assertNotNull("getCategoryByIDTestCase", category);
	//Assert.assertEquals("getCategoryByIDTest", null, category);
		
	}
	
	
	

}
