package com.ankit.cartbackend.CartBackend;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ankit.cartbackend.model.Category;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTest {
    
	public static void main(String[] args) {
		
		//we have get context
		//ask context to get the bean i.e, category
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//specify in packages the classes are there
		
		context.scan("com.ankit");
		
		context.refresh();
		
	//whatever the beans/instance you requrired you ask context
		
		Category c = (Category) context.getBean("category");
		
		
		System.out.println("Category instance created");
		//classPathxmlApplication = xml based
		
		
	
	}
	
	}

