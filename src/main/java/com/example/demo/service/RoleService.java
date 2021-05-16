package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService  {

    @Autowired
    private RoleRepository roleRepository;

    public Role insert(Role role)
    {

        return  roleRepository.saveAndFlush(role); //saveAndFlush
    }

    public void delete(Role role)
    {

        roleRepository.delete(role);
    }

    public List<Role> find()
    {
        return roleRepository.findAll();
    }

    public Optional<Role> findById(Integer id)
    {
        return roleRepository.findById(id);
    }
    public Role findByName(String name)
    {
        return roleRepository.findByName(name);
    }

    }




