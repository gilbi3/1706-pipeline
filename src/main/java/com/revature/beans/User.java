package com.revature.beans;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = -8943448747671327739L;
	
	private int id;
	private String username;
	private String first_name;
	private String last_name;
	private String pw;
	private int user_role_id;
	
	public User() {}

	public User(int id, String username, String first_name, String last_name, String pw, int user_role_id) {
		super();
		this.id = id;
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.pw = pw;
		this.user_role_id = user_role_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", pw=" + pw
				+ ", user_role_id=" + user_role_id + "]";
	}
	
	
}
