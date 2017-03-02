package com.ankit.cartbackend.dao;

import java.util.List;

import com.ankit.cartbackend.model.Category;

public interface CategoryDAO {
	
	//declare the method related to CRUD operation
	
	
	
	
	//access_specifier return_type method_name(parameter_list) throws exception_list
	
	
	//get all categories
	
	public List<Category> list();
	
	//create category
	
	public boolean save(Category category);
	
	
	
	//update category
	//if u want to update by id not possible.
	
	
	public boolean update(Category category);
	
	//delete category  by id
	//delete category by its domain object
	
	public boolean delete(String id);
	
	//delete category
	
	public boolean delete(Category category);
			
			
	//get category by id 
	
	public Category getCategoryByID(String id);
	
	//get category by name
	 
	public Category getCategoryName(String name);
	
	

	
}
