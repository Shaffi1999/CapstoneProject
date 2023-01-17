package com.smartshop.registerationandlogin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.smartshop.registerationandlogin.entity.User;
import com.smartshop.registerationandlogin.exception.UserNotFoundException;
import com.smartshop.registerationandlogin.model.Product;
import com.smartshop.registerationandlogin.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;

	
	@Override
	public User add(User user) {
		logger.info("Enterd add user service");

		return repo.save(user);
		
	}


	@Override
	public User fetchUserByEmailId(String email) {
		logger.info("Enterd fetch user by email id service");
		return repo.findByEmail(email);
	}


	@Override
	public User fetchUserByUserIdAndPassword(int userId, String password) {
		logger.info("Enterd fetchUserByUserIdAndPassword service");
		return repo.findByUserIdAndPassword(userId, password) ;
	}


	@Override
	public List<Product> getAllProducts() {
		logger.info("Enterd getAllProducts  service it will communicate with product's getAll Products Microservice");
     List<Product> products=restTemplate.getForObject("http://localhost:8083/product/getAll", List.class);
     return products;
	}


	@Override
	public User fetchByUserId(int id) {
		
		return repo.findById(id).get();
	}


	@Override
	public Boolean delteUser(int id) {
		User user=repo.findById(id).orElseThrow(()->new UserNotFoundException("User With Id :"+id+"is not present") );
		
		if(user==null)
		{
			return false;
		}
		
		repo.deleteById(id);
		return true;
	}
	
	

}
