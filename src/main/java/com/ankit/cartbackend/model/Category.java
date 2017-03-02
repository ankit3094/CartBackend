package com.ankit.cartbackend.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//add simle properties
//genrate getter/setter method 



@Entity //for contecting to the table
@Table(name="Category")    //if the class name and table name is different
@Component                 //automatically create instance of category and it is optional
public class Category {
	
	
@Id
	private String id;

@Column(name="name")  //if the field and property name is different
	private String name;

    private String description;


	public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}



	
		
	}
	