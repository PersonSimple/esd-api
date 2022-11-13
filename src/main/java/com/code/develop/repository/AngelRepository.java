package com.code.develop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.code.develop.data.AngelTable;

@Repository
public interface AngelRepository extends CrudRepository<AngelTable, Long> {
	
	
}
