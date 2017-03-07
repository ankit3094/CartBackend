package com.ankit.cartbackend.dao;

import java.util.List;

import com.ankit.cartbackend.model.Product;

public interface ProductDAO {
	
	public List<Product> list();
	
	public Product getProduct(String id);
	
	public boolean save(Product product);
	
	public boolean update(Product product);
	
	public boolean delete(String id);
	
	public Product getProductByID(String id);
	
	
	
	
	
	
	

}
