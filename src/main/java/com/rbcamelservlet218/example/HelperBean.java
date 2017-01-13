package com.rbcamelservlet218.example;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.springframework.beans.factory.annotation.Autowired;

public class HelperBean {
	
	@Autowired
	ResponsePojo response;

	@Handler
	public void buildResponse(Exchange e){
		response.setStatus("200");
		response.setService("addCountry");
		response.setMessage("Success");
		 response.setCurrTime(System.currentTimeMillis());
		 
		 e.getIn().setBody(response);
	}
}
