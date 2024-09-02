package com.javatechie.spring.mockito.api.controller;

import java.util.List;

import com.javatechie.spring.mockito.api.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javatechie.spring.mockito.api.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public  ResponseEntity<UserDTO> savedUser(@RequestBody UserDTO userDTO){
		UserDTO user =userService.addUser(userDTO);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> gettAllUsers(){
		List<UserDTO> users = userService.getUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}

	@GetMapping("/{address}")
	public ResponseEntity<List<UserDTO>> findUserByAddress(@PathVariable String address) {
		List<UserDTO> userAddress = userService.getUserByAddress(address);
		return new ResponseEntity<>(userAddress,HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable int id){
		userService.deleteUserById(id);
		return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
