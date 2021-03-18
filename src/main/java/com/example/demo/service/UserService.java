package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User insert(User user)
    {

        return  userRepository.saveAndFlush(user); //saveAndFlush
    }
    //delete id or user?
    public void delete(User user)
    {

        userRepository.delete(user);
    }

    public List<User> find()
    {
        return userRepository.findAll();
    }

    public Optional<User> findById(Integer id)
    {
        return userRepository.findById(id);
    }

    public User findByLogin(String name)
    {
        return userRepository.findByLogin(name);
    }

    public User findByPassword(String name)
    {
        return userRepository.findByPassword(name);
    }

}
