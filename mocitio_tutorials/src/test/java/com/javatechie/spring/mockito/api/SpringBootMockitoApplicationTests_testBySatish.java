//package com.javatechie.spring.mockito.api;
//
//
//import com.javatechie.spring.mockito.api.repository.UserRepository;
//import com.javatechie.spring.mockito.api.model.User;
//import com.javatechie.spring.mockito.api.service.UserService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SpringBootMockitoApplicationTests_testBySatish {
//
//	@Autowired
//	private UserService service;
//
//	@MockBean
//	private UserRepository repository;
//
//	@Test
//	public void getUsersTest() {
//		when(repository.findAll()).thenReturn(Stream
//				.of(new User(1, "neha", 26, "Pune"),
//						new User(2, "Radha", 25, "Pune")
//				).collect(Collectors.toList()));
//		assertEquals(2, service.getUsers().size());
//	}
//
//	@Test
//	public  void getUserbyAddressTest(){
//		String  address = "Pune";
//		when(repository.findByAddress(address))
//				.thenReturn(Stream.of(
//						new User(1, "neha", 26, "Pune"),
//		new User(2, "Radha", 25, "Pune")
//				).collect(Collectors.toList()));
//		assertEquals(1,service.getUserbyAddress(address).size());
//	}
//
//	@Test
//	public void saveUserTest(){
//		User user = new User(3, "shreya", 16, "Mumbai");
//		when(repository.save(user)).thenReturn(user);
//		assertEquals(user,service.addUser(user));
//	}
//
//	@Test
//	public void deleteUserTest() {
//		// Arrange
//		int userId = 1;
//		User user = new User(1, "neha", 26, "Pune");
//
//		// Mock the repository to return true when checking for the user ID
//		when(repository.existsById(userId)).thenReturn(true);
//
//		// Act
//		service.deleteUserbyId(userId);
//
//		// Assert
//		verify(repository, times(1)).deleteById(userId);
//	}
//
//
//
//}
