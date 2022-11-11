package com.code.develop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.code.develop.data.Angel;


public interface AngelRepository extends CrudRepository<Angel, Long> {
}
