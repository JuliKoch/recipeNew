package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserExistsException;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {


    @Autowired
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User insert(User user) {
        if(userRepository.findByLogin(user.getLogin())!=null)
            throw new UserExistsException("User Exists");
        else
        {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
    }

    public void delete(User user)
    {
        User delUser= userRepository.
                findById(user.getId()).
                orElseThrow(IllegalArgumentException::new);
        userRepository.delete(delUser);

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



}
