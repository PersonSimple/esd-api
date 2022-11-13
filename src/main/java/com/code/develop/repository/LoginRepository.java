package com.code.develop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.code.develop.data.AngelTable;
import com.code.develop.data.LoginTable;



public interface LoginRepository extends CrudRepository<LoginTable, Long> {
	
	@Query("Select count(*) FROM LoginTable a WHERE a.email = ?1 and a.password=?2")
	public int findByEmailAndPassword(String email,String password);
	
	
	
}
