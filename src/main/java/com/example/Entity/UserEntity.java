package com.example.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserEntity {
	@Id
	private long id;
	private String username;
	private String password;
	private int age;
	private String Addresse;
	
	public UserEntity(){}
	
	public UserEntity(long id, String username, String password, int age, String addresse) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.Addresse = addresse;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddresse() {
		return Addresse;
	}
	public void setAddresse(String addresse) {
		this.Addresse = addresse;
	}
	
	public String UsertoString(){
		String userString = this.getId() + this.getUsername() + this.getPassword() + this.getAge() + this.getAddresse();
		return userString;
	}
	
}