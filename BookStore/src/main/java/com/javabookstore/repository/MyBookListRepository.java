package com.javabookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javabookstore.entity.MyBookList;
@Repository
public interface MyBookListRepository extends JpaRepository<MyBookList,Integer>{
	
	

}
