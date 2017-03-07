package com.ankit.cartbackend.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ankit.cartbackend.dao.SupplierDAO;
import com.ankit.cartbackend.model.Supplier;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class SupplierTestCase {
	
	
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@Autowired
	private static Supplier supplier;

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void initialize()
	{
		context = new  AnnotationConfigApplicationContext();
		context.scan("com.ankit.cartbackend"); 
		context.refresh();
		
		supplier = (Supplier) context.getBean("supplier");
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		
		
		
	}

	@Test
	public void TestCreateSupplier()
	{
		supplier.setId("116");
		supplier.setName("amarjeet rao ");
		supplier.setAddress("delhi");
	
		boolean flag = supplierDAO.save(supplier);
		
		 Assert.assertEquals ("create supplierTestCase",true, flag);
		
		
	}
	@Test
	public void updateUserTestCase()
	{
		
		supplier.setId("123");
		supplier.setName("Ankit Chaurasia");
		supplier.setAddress("sec 53 noida");
		boolean flag= supplierDAO.update(supplier);
		
		Assert.assertEquals("updateUserTestCase", true, flag);
		
	
}
	
	@Test
	public void deleteSupplierTestCase()
	{
		
		
		boolean flag = supplierDAO.delete("115");
		
		Assert.assertEquals("deleteSupplierTestCase",true, flag);
		
		
	}	

}
