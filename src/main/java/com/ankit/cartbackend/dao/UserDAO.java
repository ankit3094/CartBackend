package com.ankit.cartbackend.dao;



import java.util.List;

import com.ankit.cartbackend.model.User;

public interface UserDAO {

	public List<User> list();

	public User getUser(String id);

	public boolean validate(String id, String password);

	public boolean save(User user);

	public boolean update(User user);

	public boolean delete(String id);
	
	//for deletion--to pass the doamin object in daoImpl to perform delete operation
	
	 public User getUserByID(String id);

}
