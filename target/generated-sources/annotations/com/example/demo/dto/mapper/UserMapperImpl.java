package com.example.demo.dto.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setLogin( user.getLogin() );
        userDto.setPassword( user.getPassword() );

        return userDto;
    }

    @Override
    public User toEntity(UserDto recipeDto) {
        if ( recipeDto == null ) {
            return null;
        }

        User user = new User();

        user.setLogin( recipeDto.getLogin() );
        user.setPassword( recipeDto.getPassword() );

        return user;
    }
}
