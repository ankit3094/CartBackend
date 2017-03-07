package com.ankit.cartbackend.dao.impl;




import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ankit.cartbackend.dao.UserDAO;
import com.ankit.cartbackend.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;	

	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> list() {
		
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Transactional
	public User getUser(String id) {
		return (User)sessionFactory.getCurrentSession().get(User.class, id);
		
	}

	@Transactional
	public boolean validate(String id, String password) {
		
		String hql = "from User where id = '"+ id +"' and password = '"+ password +"'";
		
		
		
		 if (sessionFactory.getCurrentSession().createQuery(hql).uniqueResult() == null)
		 {
			 return false;
			 
		 }
		 return true;
		 	 
	}

     @Transactional
	public boolean save(User user) {
		
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
			
		}
	}

	@Transactional
	public boolean update(User user) {
		
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
			
		}
	}


	@Transactional
	public boolean delete(String id) {
		
		try {
			sessionFactory.getCurrentSession().delete(getUserByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


    @Transactional
	public User getUserByID(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class,id);
	}


 
	

	
		


	

}
