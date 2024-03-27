package com.example.newSearch.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newSearch.Entity.*;

public interface repository extends JpaRepository<book, Long> {
   
	
}
