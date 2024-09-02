package com.javatechie.spring.mockito.api.service;

import com.javatechie.spring.mockito.api.dto.UserDTO;
import com.javatechie.spring.mockito.api.mapper.UserMapper;
import com.javatechie.spring.mockito.api.model.User;
import com.javatechie.spring.mockito.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        System.out.println("Adding user: " + userDTO);
        User user = userMapper.toEntity(userDTO);
        System.out.println("Converted to entity: " + user);
        User saveUser = userRepository.save(user);
        System.out.println("Saved user: " + saveUser);
        UserDTO result = userMapper.toDTO(saveUser);
        System.out.println("Converted back to DTO: " + result);
        return result;
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        System.out.println("Retrieved users: " + users);
        List<UserDTO> userDTOs = users.stream().map(userMapper::toDTO).collect(Collectors.toList());
        System.out.println("Converted to DTOs: " + userDTOs);
        return userDTOs;
    }

    @Override
    public List<UserDTO> getUserByAddress(String address) {
        System.out.println("Getting users by address: " + address);
        List<User> users = userRepository.findByAddress(address);
        System.out.println("Retrieved users: " + users);
        List<UserDTO> userDTOs = users.stream().map(userMapper::toDTO).collect(Collectors.toList());
        System.out.println("Converted to DTOs: " + userDTOs);
        return userDTOs;
    }

    @Override
    public void deleteUserById(int id) {
        System.out.println("Checking existence of user with ID: " + id);
        if (userRepository.existsById(id)) {
            System.out.println("User with ID " + id + " exists. Deleting...");
            userRepository.deleteById(id);
            System.out.println("User with ID " + id + " was successfully deleted.");
        } else {
            System.out.println("User with ID " + id + " does not exist.");
        }
    }

    @Override
    public Optional<UserDTO> getUserById(int id) {
        System.out.println("Getting user by ID: " + id);
        Optional<User> userOptional = userRepository.findById(id);
        System.out.println("Retrieved user: " + userOptional);
        Optional<UserDTO> userDTOOptional = userOptional.map(userMapper::toDTO);
        System.out.println("Converted to DTO: " + userDTOOptional);
        return userDTOOptional;
    }
}
