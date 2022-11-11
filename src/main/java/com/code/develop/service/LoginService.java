package com.code.develop.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.code.develop.model.SignInData;
import com.code.develop.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository repository;
	
	
	public int validateLogin(SignInData signIn) {
		
	      return repository.findByEmailAndPassword(signIn.getEmail(), signIn.getPassword());
		//query  " select count (*) from LoginTable where email ='singIn.email and passowrd ='singin.password';
	}
}
