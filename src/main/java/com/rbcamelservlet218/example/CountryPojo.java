package com.rbcamelservlet218.example;

public class CountryPojo {

	public CountryPojo() {
	}
	
	public CountryPojo(int id, String city, String postCode, String country) {
		super();
		this.id = id;
		this.city = city;
		this.postCode = postCode;
		this.country = country;
	}
	int id;
	String city;
	String postCode;
	String country;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return String.format("CountryPojo [id=%s, city=%s, postCode=%s, country=%s]", id, city, postCode, country);
	}
	
	
}