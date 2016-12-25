package com.rbcamelservlet218.example;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RbCamelservlet218XamplesApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testHelloWorld() {
		ResponseEntity<String> response = this.restTemplate.getForEntity("/camel/say/hello", String.class, "Phil");
		assertTrue(response.hasBody());
		
		System.out.println("Response Body_helloWorld:" +response.getBody());
	}
	
	@Test
	public void testUserLives() {
		
		   final String USER_NAME = "Leif Ericson";

		    UserPojo user = new UserPojo();
		    user.setId(130);
		    user.setFname(USER_NAME);
		    
		    @SuppressWarnings("unchecked")
			ResponseEntity<CountryPojo> response = 
		    		restTemplate.postForEntity("/camel/users/lives", user, CountryPojo.class, Collections.EMPTY_MAP);
		    assertThat( response.getStatusCode() , equalTo(HttpStatus.OK));
		    
		    assertTrue(response.hasBody());
		    
		    assertThat(response.getBody().getCity(), equalTo("abc"));
		     
		System.out.println("Response Body_userlives:" +response.getBody());
	}
}
