package com.ankit.cartbackend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ankit.cartbackend.dao.SupplierDAO;
import com.ankit.cartbackend.model.Supplier;


@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	
	public SupplierDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

    @SuppressWarnings("unchecked")
	@Transactional
	public List<Supplier> list() {
    	
    	return sessionFactory.getCurrentSession().createQuery(" from Supplier").list();
		}


	public Supplier getSupplier(String id) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);
		
	
	}

@Transactional
	public boolean save(Supplier supplier) {
	
	try {
		sessionFactory.getCurrentSession().save(supplier);
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	
	}

   @Transactional
	public boolean update(Supplier supplier) {
		
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}

   @Transactional
	public boolean delete(String id) {
	   try {
		sessionFactory.getCurrentSession().delete(getSupplierByID(id));
		return true;
	} catch (Exception e) {
		
		e.printStackTrace();
		return false;
	}
	   
	   
		
	}

@Transactional
	public Supplier getSupplierByID(String id) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class,id);
		
		
		
	}

}
