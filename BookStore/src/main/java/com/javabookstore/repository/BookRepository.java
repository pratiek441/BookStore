package com.javabookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javabookstore.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{

}
