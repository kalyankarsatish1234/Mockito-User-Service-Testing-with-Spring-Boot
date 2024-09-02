package com.javatechie.spring.mockito.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.javatechie.spring.mockito.api.dto.UserDTO;
import com.javatechie.spring.mockito.api.mapper.UserMapper;
import com.javatechie.spring.mockito.api.model.User;
import com.javatechie.spring.mockito.api.repository.UserRepository;
import com.javatechie.spring.mockito.api.service.UserServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceImplTests {

    @Autowired
    private UserServiceImpl userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserMapper userMapper;

    @Test
    public void addUserTest() {
        UserDTO userDTO = new UserDTO(999, "Pranya", 33, "Pune");
        User user = new User(999, "Pranya", 33, "Pune");
        User savedUser = new User(999, "Pranya", 33, "Pune");

        when(userMapper.toEntity(userDTO)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(savedUser);
        when(userMapper.toDTO(savedUser)).thenReturn(userDTO);

        UserDTO result = userService.addUser(userDTO);

        assertEquals(userDTO, result);
        verify(userMapper, times(1)).toEntity(userDTO);
        verify(userRepository, times(1)).save(user);
        verify(userMapper, times(1)).toDTO(savedUser);
    }

    @Test
    public void getUsersTest() {
        User user1 = new User(1, "Alice", 30, "New York");
        User user2 = new User(2, "Bob", 25, "Los Angeles");
        UserDTO userDTO1 = new UserDTO(1, "Alice", 30, "New York");
        UserDTO userDTO2 = new UserDTO(2, "Bob", 25, "Los Angeles");

        when(userRepository.findAll()).thenReturn(Stream.of(user1, user2).collect(Collectors.toList()));
        when(userMapper.toDTO(user1)).thenReturn(userDTO1);
        when(userMapper.toDTO(user2)).thenReturn(userDTO2);

        List<UserDTO> result = userService.getUsers();

        assertEquals(2, result.size());
        assertEquals(userDTO1, result.get(0));
        assertEquals(userDTO2, result.get(1));
    }

    @Test
    public void getUserByAddressTest() {
        String address = "Bangalore";
        User user = new User(376, "Daniel", 31, address);
        UserDTO userDTO = new UserDTO(376, "Daniel", 31, address);

        when(userRepository.findByAddress(address)).thenReturn(Stream.of(user).collect(Collectors.toList()));
        when(userMapper.toDTO(user)).thenReturn(userDTO);

        List<UserDTO> result = userService.getUserByAddress(address);

        assertEquals(1, result.size());
        assertEquals(userDTO, result.get(0));
    }

    @Test
    public void deleteUserByIdTest() {
        int id = 999;
        when(userRepository.existsById(id)).thenReturn(true);

        userService.deleteUserById(id);

        verify(userRepository, times(1)).deleteById(id);
    }

    @Test
    public void getUserByIdTest() {
        int id = 999;
        User user = new User(id, "Pranya", 33, "Pune");
        UserDTO userDTO = new UserDTO(id, "Pranya", 33, "Pune");

        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        when(userMapper.toDTO(user)).thenReturn(userDTO);

        Optional<UserDTO> result = userService.getUserById(id);

        assertEquals(Optional.of(userDTO), result);
    }
}
