//package com.javatechie.spring.mockito.api.controller;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import com.javatechie.spring.mockito.api.dto.UserDTO;
//import com.javatechie.spring.mockito.api.service.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Collections;
//import java.util.List;
//
//@WebMvcTest(UserController.class)
//public class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private UserService userService;
//
//    @InjectMocks
//    private UserController userController;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void savedUserTest() throws Exception {
//        UserDTO userDTO = new UserDTO(999, "Pranya", 33, "Pune");
//        when(userService.addUser(any(UserDTO.class))).thenReturn(userDTO);
//
//        mockMvc.perform(post("/User")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"id\":999,\"name\":\"Pranya\",\"age\":33,\"address\":\"Pune\"}"))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id").value(999))
//                .andExpect(jsonPath("$.name").value("Pranya"))
//                .andExpect(jsonPath("$.age").value(33))
//                .andExpect(jsonPath("$.address").value("Pune"));
//    }
//
//    @Test
//    public void getAllUsersTest() throws Exception {
//        UserDTO userDTO = new UserDTO(999, "Pranya", 33, "Pune");
//        List<UserDTO> users = Collections.singletonList(userDTO);
//        when(userService.getUsers()).thenReturn(users);
//
//        mockMvc.perform(get("/User")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(999))
//                .andExpect(jsonPath("$[0].name").value("Pranya"))
//                .andExpect(jsonPath("$[0].age").value(33))
//                .andExpect(jsonPath("$[0].address").value("Pune"));
//    }
//
//    @Test
//    public void findUserByAddressTest() throws Exception {
//        String address = "Pune";
//        UserDTO userDTO = new UserDTO(999, "Pranya", 33, address);
//        List<UserDTO> users = Collections.singletonList(userDTO);
//        when(userService.getUserByAddress(address)).thenReturn(users);
//
//        mockMvc.perform(get("/User/{address}", address)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(999))
//                .andExpect(jsonPath("$[0].name").value("Pranya"))
//                .andExpect(jsonPath("$[0].age").value(33))
//                .andExpect(jsonPath("$[0].address").value(address));
//    }
//
//    @Test
//    public void deleteUserByIdTest() throws Exception {
//        int id = 999;
//        doNothing().when(userService).deleteUserById(id);
//
//        mockMvc.perform(delete("/User/{id}", id)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNoContent());
//    }
//}
