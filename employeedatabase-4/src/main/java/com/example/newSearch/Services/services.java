package com.example.newSearch.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.newSearch.Entity.book;
import com.example.newSearch.Repository.repository;

@Service
public class services {
@Autowired
  repository newRepository;

public List<book> getAllBooks() {
    return newRepository.findAll();
}

public Optional<book> getBookById(Long id) {
    return newRepository.findById(id);
}

public book saveBook(book book) {
    return newRepository.save(book);
}

public void deleteBook(Long id) {
    newRepository.deleteById(id);
}
}
