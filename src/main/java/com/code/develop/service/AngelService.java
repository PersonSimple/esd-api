package com.code.develop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.develop.data.AngelTable;
import com.code.develop.model.AngelUser;
import com.code.develop.repository.AngelRepository;

@Service
public class AngelService {

	@Autowired
	private AngelRepository repository;
	
	@Autowired
	private AngelTable angelTable;
	
	
	public  AngelTable saveAngelUserDetail( AngelUser angelUser) {
		//before save we need the to transfer the values from angelUser pojo  to angleTable pojo
		angelTable.setAhAddress(angelUser.getAhAddress());
		angelTable.setAhContactNumber(angelUser.getAhContactNumber());
		angelTable.setAhEmail(angelUser.getAhEmail());
		angelTable.setAhName(angelUser.getAhName());

		return repository.save(angelTable);
	}
	
	
}
