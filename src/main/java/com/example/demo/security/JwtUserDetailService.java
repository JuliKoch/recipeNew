package com.example.demo.security;

import com.example.demo.entity.User;
import com.example.demo.security.jwt.JwtUser;
import com.example.demo.security.jwt.JwtUserFactory;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserDetailsService")
public class JwtUserDetailService implements UserDetailsService {

    private  final UserService userService;

    @Autowired
    public JwtUserDetailService(UserService userService)
    {
        this.userService=userService;
    }
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user=userService.findByLogin(login);

        if(user==null)
        {
            throw new UsernameNotFoundException("User with login: "+ login+" not found");
        }
        return  JwtUserFactory.create(user);
    }
}
