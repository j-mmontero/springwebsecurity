package com.ncc.reports;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

	Logger logger = LoggerFactory.getLogger(WebController.class);
	
	@RequestMapping(value={ "/", "/login"},  method = RequestMethod.GET)
	public String login() {
		
		logger.info("Inside LOGIN GET");
		
		return "login";
	}
	

	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String validateLogin() {
		logger.info("Inside LOGIN POST User: {}");
		return "welcome";
	}	
	
	@RequestMapping(value={ "/report"},  method = RequestMethod.GET)
	public String report() {
		
		HttpHeaders headers = new HttpHeaders();
		String plainCreds = "willie:p@ssword";
		byte[] plainCredsBytes = plainCreds.getBytes();
//		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
//		String base64Creds = new String(base64CredsBytes);
//		headers.add("Authorization", "Basic " + base64Creds);
		  
		logger.info("Inside Report");
		
		return "report";
	}
}
