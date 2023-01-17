package com.smartshop.registerationandlogin.service;

import java.util.List;

import com.smartshop.registerationandlogin.entity.User;
import com.smartshop.registerationandlogin.model.Product;

public interface IUserService {
public User add(User registeration);
public User fetchUserByEmailId(String email);
public User fetchUserByUserIdAndPassword(int userId,String password);
public List<Product> getAllProducts();
public User fetchByUserId(int id);
public Boolean delteUser(int id);
}
