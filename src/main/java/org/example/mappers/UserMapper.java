package org.example.mappers;

import org.example.domain.User;
import org.example.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User userDtoToUser(UserDto userDto);

    @Mapping(source = "password", target = "password", ignore = true)
    UserDto userToUserDto(User user);
}
