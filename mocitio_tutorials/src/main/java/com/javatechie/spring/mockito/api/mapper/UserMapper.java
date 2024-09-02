package com.javatechie.spring.mockito.api.mapper;

import com.javatechie.spring.mockito.api.dto.UserDTO;
import com.javatechie.spring.mockito.api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
UserMapper INSTACE = Mappers.getMapper(UserMapper.class);
//convert userDTO to user
User toEntity(UserDTO userDTO);
//convert User to UserDTO
UserDTO toDTO(User user);

}
