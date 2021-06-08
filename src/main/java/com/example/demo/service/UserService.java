package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.exception.UserExistsException;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = passwordEncoder;
    }
//    public User insert(User user) {
//        if(userRepository.findByLogin(user.getLogin())!=null)
//            throw new UserExistsException("User Exists");
//        else
//        {
//            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//            return userRepository.save(user);
//        }
//    }
public User insert(User user) {

    Role roleUser=roleRepository.findByName("USER");
    List<Role> userRoles=new ArrayList<>();
    userRoles.add(roleUser);

    user.setRoles(userRoles);
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

    return userRepository.save(user);
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

    public User findById(Integer id)
    {
        return userRepository.findById(id).orElse(null);
    }

    public Optional< User> findByLogin(String name)
    {
        return userRepository.findByLogin(name);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return this.userRepository.findByLogin(s).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
    }
}
