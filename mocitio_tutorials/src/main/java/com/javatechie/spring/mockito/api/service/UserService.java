package com.javatechie.spring.mockito.api.service;


import com.javatechie.spring.mockito.api.dto.UserDTO;
import com.javatechie.spring.mockito.api.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

//	@Autowired
//	private UserRepository repository;
	

//	public User addUser(User user) {
//		User saveUser = repository.save(user);
//		System.out.println("Getting data from DB : " + saveUser);
//		return saveUser;
//	}
//
//	public List<User> getUsers() {
//		List<User> users = repository.findAll();
//		System.out.println("Getting data from DB : " + users);
//		return users;
//	}
//
//	public List<User> getUserbyAddress(String address) {
//		List<User> users = repository.findByAddress(address);
//		System.out.println("Getting data from DB : " + users);
//		return users;
//	}
//
//	public void deleteUserbyId(int id) {
//		if (repository.existsById(id)) {
//			repository.deleteById(id);
//			System.out.println("User with ID " + id + " was successfully deleted.");
//		} else {
//			System.out.println("User with ID " + id + " does not exist.");
//		}
//	}
    public UserDTO addUser(UserDTO userDTO);
    public List<UserDTO> getUsers();
    public List<UserDTO> getUserByAddress(String address);
    public void deleteUserById(int id);
    public Optional<UserDTO> getUserById(int id);
}
