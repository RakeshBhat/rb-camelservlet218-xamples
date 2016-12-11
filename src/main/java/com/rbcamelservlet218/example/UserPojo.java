package com.rbcamelservlet218.example;

public class UserPojo {
	
	int id;
	String fname;
	String lname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return String.format("UserPojo [id=%s, fname=%s, lname=%s]", id, fname, lname);
	}

	
}