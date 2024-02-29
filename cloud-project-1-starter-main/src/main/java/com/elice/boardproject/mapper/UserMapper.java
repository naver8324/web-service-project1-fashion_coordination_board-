package com.elice.boardproject.mapper;

import com.elice.boardproject.entity.User;
import com.elice.boardproject.entity.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userPostDtoToUser(UserDto userDto);
}
