package com.smartshop.registerationandlogin.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.smartshop.registerationandlogin.entity.User;
import com.smartshop.registerationandlogin.repository.UserRepository;
import com.smartshop.registerationandlogin.service.UserServiceImpl;
@ExtendWith(value= {MockitoExtension.class})
class UserServiceTest {
	
	@Mock
	UserRepository repo;
	
	@InjectMocks
	UserServiceImpl service;

	@Test
	void testAdd() {
		User user=new User(1,"Shaffi","Mohammad","15-10-1999","Male","67868768","imran8096793447@gmail.com","Shaffi@1999","Customer");
	     when(repo.save(user)).thenReturn(user);
	     assertEquals(user,service.add(user));
	}

	@Test
	void testFetchUserByEmailId() {
		User user=new User(1,"Shaffi","Mohammad","15-10-1999","Male","67868768","imran8096793447@gmail.com","Shaffi@1999","Customer");
		Mockito.when(repo.findByEmail("imran8096793447@gmail.com")).thenReturn(user);
		User actuals=service.fetchUserByEmailId("imran8096793447@gmail.com");
		assertEquals(actuals,user);
	}

	@Test
	void testFetchUserByUserIdAndPassword() {
		User user=new User(1,"Shaffi","Mohammad","15-10-1999","Male","67868768","imran8096793447@gmail.com","Shaffi@1999","Customer");
		Mockito.when(repo.findByUserIdAndPassword(1,"Shaffi@1999")).thenReturn(user);
		User actuals=service.fetchUserByUserIdAndPassword(1,"Shaffi@1999");
		assertEquals(actuals,user);
	}

	@Test
	void testGetAllProducts() {
		fail("Not yet implemented");
	}

}
