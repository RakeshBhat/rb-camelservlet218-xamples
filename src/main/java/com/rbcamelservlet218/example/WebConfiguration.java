package com.rbcamelservlet218.example;

import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration of web application with Servlet 3.0 APIs.
 */
@Configuration
public class WebConfiguration  implements ServletContextInitializer {

	Logger log = Logger.getLogger(WebConfiguration.class.getName());

	private static final String CAMEL_URL_MAPPING = "/camel/*";
	private static final String CAMEL_SERVLET_NAME = "CamelServlet";

//	@Bean
//	public ServletRegistrationBean servletRegistrationBean() {
//		ServletRegistrationBean registration = new ServletRegistrationBean(new CamelHttpTransportServlet(),
//				CAMEL_URL_MAPPING);
//		registration.setName(CAMEL_SERVLET_NAME);
//		return registration;
//	}

	 @Override
	 public void onStartup(ServletContext servletContext) throws
	 ServletException {
	 log.info("Web application configuration, using profiles: {}");
	 initCamelServlet(servletContext);
	 log.info("Web application fully configured");
	 }
	
	
	
	 /**
	 * Initializes Metrics.
	 */
	 private void initCamelServlet(ServletContext servletContext) {
	 ServletRegistration.Dynamic metricsAdminServlet =
	 servletContext.addServlet(CAMEL_SERVLET_NAME, new
	 CamelHttpTransportServlet());
	
	 metricsAdminServlet.addMapping(CAMEL_URL_MAPPING);
	 metricsAdminServlet.setAsyncSupported(true);
	 metricsAdminServlet.setLoadOnStartup(1);
	 }
	

}
