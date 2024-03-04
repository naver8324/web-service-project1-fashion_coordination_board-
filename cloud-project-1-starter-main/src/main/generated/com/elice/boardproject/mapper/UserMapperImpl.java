package com.elice.boardproject.mapper;

import com.elice.boardproject.entity.User;
import com.elice.boardproject.entity.UserDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-29T14:40:46+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userPostDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setLoginId( userDto.getLoginId() );
        user.setPassword( userDto.getPassword() );
        user.setName( userDto.getName() );

        return user;
    }
}
