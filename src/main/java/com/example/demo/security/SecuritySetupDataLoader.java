package com.example.demo.security;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class SecuritySetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(alreadySetup)
            return;
        this.createRoleIfNotFound("ADMIN");
        this.createRoleIfNotFound("USER");
        this.createDefaultAdmin();

        alreadySetup = true;
    }

    User createDefaultAdmin() {
        return userRepository.findByLogin("ADMIN").orElseGet(()->{
            User user = new User();
            user.setLogin("ADMIN");
            user.setPassword(passwordEncoder.encode("ADMIN"));
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findByName("ADMIN"));
            user.setRoles(roles);
            return userRepository.save(user);
        });

    }

    Role createRoleIfNotFound(String name) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role();
            role.setNameRole(name);
        }
        return role;
    }
}