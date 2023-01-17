package com.smartshop.registerationandlogin.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartshop.registerationandlogin.entity.User;
import com.smartshop.registerationandlogin.exception.InvalidException;
import com.smartshop.registerationandlogin.model.Product;
import com.smartshop.registerationandlogin.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserServiceImpl service;

	@PostMapping("/add")
	public User add(@Valid @RequestBody User registeration) throws Exception {
		logger.info("Entered into add User rest api");
		String email = registeration.getEmail();
		if (email != null && !"".equals(email)) {
			User registerationObj = service.fetchUserByEmailId(email);
			if (registerationObj != null) {
				logger.warn("This email is already exist");
				throw new InvalidException("User With This Email Id " + email + "Is Already Exist:");
			}
		}

		return service.add(registeration);
	}

	@PostMapping("/login")
	public User authenticateLogin(@RequestBody User registeration) throws Exception {
		logger.info("Entered Authenticate Login Rest Api");
		int userId = registeration.getUserId();
		String password = registeration.getPassword();
		User registerationObj = null;
		if (userId != 0 && password != null) {
			registerationObj = service.fetchUserByUserIdAndPassword(userId, password);
		}
		if (registerationObj == null) {
			logger.warn("Bad Credentials");
			throw new InvalidException("Bad Credentials");
		}
		return registerationObj;
	}

	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		logger.info("Entered get All Products Rest Api");
		return service.getAllProducts();
	}

	@GetMapping("/get/{id}")

	public User getUserById(@PathVariable("id") int id) {
		return service.fetchByUserId(id);
	}

	@DeleteMapping("/deleteById/{id}")
	public boolean deleteUserById(@PathVariable("id") int id) {
		return service.delteUser(id);
	}
}
