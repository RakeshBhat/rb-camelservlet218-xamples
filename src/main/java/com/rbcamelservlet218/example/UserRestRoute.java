package com.rbcamelservlet218.example;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;


@Component
public class UserRestRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
				
		restConfiguration().component("servlet").bindingMode(RestBindingMode.json);
		onException(JsonParseException.class).handled(true)
		.setHeader(Exchange.HTTP_RESPONSE_CODE,constant(400))
		.setHeader(Exchange.CONTENT_TYPE, constant("text/plain"))
		.setBody().constant("Invalid json data received.");
		
		rest("/say/hello")
        .get().route().transform().constant("Hello World");
		
		rest("/users/")
		.consumes("application/json")
		.produces("application/json")
	    .post("lives").type(UserPojo.class).outType(CountryPojo.class)
	        .route()
	        	            .choice()
	                .when().simple("${body.id} < 100")
	                    .log("${body}")
	                    .bean(new UserErrorService(), "idToLowError")
	                .otherwise()
	                    .bean(new UserService(), "livesWhere");
		
		rest("/country/")
		.consumes("application/json")
		.produces("application/json")
		.post().type(CountryPojo.class).outType(ResponsePojo.class)
		.to("direct:addCountry");
		
		from("direct:addCountry")
		.log(LoggingLevel.INFO, "received addCountry request.")
		.wireTap("direct:proccessingRecords")
		.bean(HelperBean.class, "buildResponse")
		.log(LoggingLevel.INFO, "replying back to client.")
		.transform(simple("${body}"));
		
		
		from("direct:proccessingRecords")
		.log(LoggingLevel.INFO, "continue processing request")
		.delay(2000)
		.loop(9)
		.to("direct:helperRoute")
		.log(LoggingLevel.INFO, "completed processing request");
		
		
		rest("/country/")
		.consumes("application/json")
		.produces("application/json")
		.post("lives").type(CountryPojo.class).outType(ResponsePojo.class)
		.to("direct:newCountry");
		
		from("direct:newCountry")
		.log(LoggingLevel.INFO, "received addCountry request.")
		.to("seda:proccessingRecords")
		.bean(HelperBean.class, "buildResponse")
		.log(LoggingLevel.INFO, "replying back to client.")
		.transform(simple("${body}"));		
		
		from("seda:proccessingRecords")
		.log(LoggingLevel.INFO, "continue processing request")
		.delay(2000)
		.loop(9)
		.to("direct:helperRoute")
		.log(LoggingLevel.INFO, "completed processing request");
		
		from("direct:helperRoute")
		.log(LoggingLevel.INFO, "looping....");
		
	}

}