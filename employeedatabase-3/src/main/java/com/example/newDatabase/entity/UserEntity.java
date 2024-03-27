package com.example.newDatabase.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class UserEntity {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 private String userName;
 private String password;
public UserEntity(String userName, String password) {
	super();
	this.userName = userName;
	this.password = password;
}

public UserEntity() {
	
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
