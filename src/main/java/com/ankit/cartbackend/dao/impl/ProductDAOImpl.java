package com.ankit.cartbackend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ankit.cartbackend.dao.ProductDAO;
import com.ankit.cartbackend.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProduct(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product getProductByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	

}
