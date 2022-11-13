package com.code.develop.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.code.develop.data.AngelTable;
import com.code.develop.model.AngelUser;
import com.code.develop.repository.AngelRepository;
import com.code.develop.service.AngelService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AngelController {

	@Autowired
	private AngelService service;

/*
	@PostMapping("/angelUser/saveAngelUser")
	public AngelTable saveAngelUserDetail(@ModelAttribute AngelUser angelUser, 
			                              @RequestParam("file") MultipartFile file) throws IOException {
         
		angelUser.setFileName(file.getName());
		angelUser.setFileType(file.getContentType());
		angelUser.setData(file.getBytes());
		return service.saveAngelUserDetail(angelUser);

		
	}
*/
	@PostMapping("/angelUser/saveAngelUser")
	public AngelTable saveAngelUserDetail(@RequestBody AngelUser angelUser ) throws IOException {
			return service.saveAngelUserDetail(angelUser);
	}
	
	@DeleteMapping("/angelUser/deleteAngelUserById/{ahId}")
	public Boolean deleteAngelUserById(@PathVariable("ahId") Long ahId) {
		// stub code
		return true;
	}

	@PutMapping("/angelUser/updateAngelUserById")
	public ResponseEntity<AngelUser> updateAngelUserById(@RequestBody AngelUser angelUser) {
		// stub code
		return new ResponseEntity<>(new AngelUser(), HttpStatus.OK);
	}

	@GetMapping("/angelUser/getAngelUserById/{ahId}")
	public ResponseEntity<AngelUser> getAngelUserById(@PathVariable("ahId") Long ahId) {
		// stub code
		return new ResponseEntity<AngelUser>(new AngelUser(), HttpStatus.OK); // object having the provided id
	}

	@GetMapping("/angelUser/getAllAngelUser")
	public ResponseEntity<ArrayList<AngelUser>> getAllAngelUser() {
		// stub code
		ArrayList<AngelUser> listAngel = new ArrayList<AngelUser>();
		return new ResponseEntity<>(listAngel, HttpStatus.OK); // object having the provided id
	}

}
