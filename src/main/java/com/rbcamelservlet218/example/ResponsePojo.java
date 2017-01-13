package com.rbcamelservlet218.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ResponsePojo {
	
	
	String service;
	String status;
	String message;
	Long currTime;
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getCurrTime() {
		return currTime;
	}
	public void setCurrTime(Long currTime) {
		this.currTime = currTime;
	}
	@Override
	public String toString() {
		return String.format("ResponsePojo [service=%s, status=%s, message=%s, currTime=%s]", service, status, message,
				currTime);
	}
	
	

}
