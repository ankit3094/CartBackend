package com.ankit.cartbackend.dao;

import java.util.List;

import com.ankit.cartbackend.model.Supplier;

public interface SupplierDAO {
	
	public List<Supplier> list();
	
    public Supplier getSupplier(String id);
    
    public boolean save(Supplier supplier);
    
    public boolean update(Supplier supplier);
     
    public boolean delete(String id);
    
    public Supplier getSupplierByID(String id);
}
