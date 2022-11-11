package com.code.develop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.develop.model.SignInData;
import com.code.develop.service.LoginService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")


/**
 * 
 * @author kailashdimri
 * this class received the login detail and fetch the result
 *
 */

public class LoginController {
	
	private static final Logger log =LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService service;
	
	@PostMapping("/loginhelper/login")
	public ResponseEntity<String> angelLogin(@RequestBody SignInData signIn) {
		log.info("login sign in request " + signIn.toString());
		int result = service.validateLogin(signIn);
		String res = (result > 0) ?  "Login SuccessFull" :  "Wrong email or password"; // 
		return  new ResponseEntity<>(res ,HttpStatus.OK);
	}
	
/**
 * 
 * @param signIn
 * @return ResponseEntity<String>
 */
	
	@PostMapping("/loginhelper/changepassword")
	public  ResponseEntity<String> changeLoginPassword( @RequestBody SignInData signIn) {
		return  new ResponseEntity<>("Password Changed" ,HttpStatus.OK);
	}
	

}
