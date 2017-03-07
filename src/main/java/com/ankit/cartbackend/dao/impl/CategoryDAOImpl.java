package com.ankit.cartbackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

//category ctrl+
//session is nothing it is physical connection

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ankit.cartbackend.dao.CategoryDAO;
import com.ankit.cartbackend.model.Category;


@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

@Autowired

private SessionFactory sessionFactory;


//CategoryDAoImpl c = new CateogoryDAOImpl


public CategoryDAOImpl(SessionFactory sessionFactory) {
super();
this.sessionFactory = sessionFactory;
}


	public List<Category> list() {
		// select * from category -sql query
		//from Category -> HQL mention domain class name not table name and filed name
		
		//convert the hibernate  query into db specific language
	return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}




    @Transactional
	public boolean save(Category category) {
		try
		{
			
		
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(category); //open session and when table is created implecitly
		return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	

    @Transactional
	public boolean update(Category category) {
		

			try {
				sessionFactory.getCurrentSession().update(category);
				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		
		
	}
	
	//for adding try catch select the session factory line right click on go to surrounded with	
	
     @Transactional
	public boolean delete(String id) {
	 try {
		sessionFactory.getCurrentSession().delete(getCategoryByID(id));
		return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
	}
		
	
	
     
     //cntrl +

	@Transactional
	public boolean delete(Category category) {
		
		try
		{	
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(category);
		return true;
		}catch(Exception e) {
	
			e.printStackTrace();
			return false;
		}

	}
/*
 * 
 * 
 */
	
	public Category getCategoryByID(String id) {
		
		//select * from category where id = ?
	return (Category)sessionFactory.getCurrentSession().get(Category.class, id);
	
		//return (Category) sessionFactory.getCurrentSession().createQuery("from Category where id = '"+id + "'").uniqueResult();
		//<-----if the id is primary key
	//definetly u will get the only one result^
	//sessionFactory.getCurrentSession().createQuery("from Category where id = '"+id + "'").list().get(0);
        
	
	
	}

 


  @Transactional
public Category getCategoryByName(String name) {
	  
	  //select * from category where name = 'mobile'
	return (Category)sessionFactory.getCurrentSession().createQuery("from Category where id = '"+name + "'").list().get(0);
}





}
