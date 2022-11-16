package com.code.develop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
	
	@Autowired
    AngelRepository  repo;
	

	@PostMapping("/angelUser/saveAngelUser")
	public AngelUser saveAngelUserDetail(@ModelAttribute AngelUser angelUser, 
			                              @RequestParam("file") MultipartFile file) throws IOException {
         
		angelUser.setFileName(file.getName());
		angelUser.setFileType(file.getContentType());
		angelUser.setData(file.getBytes());
		return service.saveAngelUserDetail(angelUser);
	}



	   @GetMapping("/angelUser/profileImage/{fileName}")
	   public ResponseEntity getImage(@PathVariable long fileName) {
		   AngelUser document = service.findById(fileName);
	   	return ResponseEntity.ok()
	   			.contentType(MediaType.parseMediaType("application/octet-stream"))
	   			.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFileName() + "\"")
	   			.body(document.getData());
	   }
	   
	   
	   
	@DeleteMapping("/angelUser/deleteAngelUserById/{ahId}")
	public String deleteAngelUserById(@PathVariable("ahId") Long ahId) {
	     return	service.deleteAngelUserById(ahId);	 //done	
	}

	@PutMapping("/angelUser/updateAngelUserById")
	public ResponseEntity<AngelUser> updateAngelUserById(@RequestBody AngelUser angelUser) {
			service.updateAngelUserById(angelUser);
		return new ResponseEntity<>(new AngelUser(), HttpStatus.OK);
	}

	@GetMapping("/angelUser/getAngelUserById/{ahId}")
	public ResponseEntity<AngelTable> getAngelUserById(@PathVariable("ahId") Long ahId) {
		//AngelTable record = repo.findById(ahId).get();
		return new ResponseEntity<AngelTable>(repo.findById(ahId).get(), HttpStatus.OK); // object having the provided id
	}

	@GetMapping("/angelUser/getAllAngelUser")
	public ResponseEntity<Iterable<AngelUser>> getAllAngelUser() {
		Iterable <AngelUser> listAngel = service.getAllAngelUser();
		return new ResponseEntity<>(listAngel, HttpStatus.OK); // object having the provided id
	}

}
