/**
 * 
 */
package com.rts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rts.bo.ManagerBo;
import com.rts.bo.Response;
import com.rts.service.ManagerService;

@RestController
@RequestMapping(value = "/v1/manager")
public class ManagerController {
	private static final Logger log = LogManager.getLogger(ManagerController.class);
	
	@Autowired
	private ManagerService managerServce;
	
	@CrossOrigin
	@PostMapping(value = "/sign-up")
	public Response signUp(@RequestBody ManagerBo managerBo) {
		Response response = new Response();
		try {		
			managerServce.signupManeger(managerBo);
			response.setStatus("200");
			response.setMessage("User Registered Successfully");
			response.setResult(managerBo);
			return response;
		
		} catch (Exception e) {
			log.error("Error In : signUpConfirmation()", e);
			response.setStatus("500");
			response.setMessage("internal server error");
			return response;
		}
	}
	
	
	
	@CrossOrigin
	@PostMapping(value = "/login")
	public Response loginuser(@RequestBody  ManagerBo managerBo) {
		Response response = new Response();
		try {
			managerServce.loginManager(managerBo);
			response.setStatus("200");
			response.setMessage("User Login Successfully");
			response.setResult(managerBo);
			return response;
		
		} catch (Exception e) {
			log.error("Error In : loginuser()", e);
			response.setStatus("500");
			response.setMessage("internal server error");
			return response;
		}
	}
	
	

}
