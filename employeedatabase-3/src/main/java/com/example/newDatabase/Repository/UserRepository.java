package com.example.newDatabase.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newDatabase.entity.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity , Long> {
  Optional<UserEntity> findByUserName(String userName);
}
