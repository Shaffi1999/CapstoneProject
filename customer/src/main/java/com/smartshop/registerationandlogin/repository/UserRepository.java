package com.smartshop.registerationandlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartshop.registerationandlogin.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
public User findByEmail(String email);
public User findByUserIdAndPassword(int userId,String password);
}
