package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Role;
import com.arefin.sunshinefarm.entity.User;
import com.arefin.sunshinefarm.repo.RoleRepo;
import com.arefin.sunshinefarm.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Controller
public class TestController {
    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/role-save")
    public String saveRole(){
        Set<Role> role = new HashSet<>();
        role.add(new Role("ADMIN"));
        role.add(new Role("CUSTOMERS"));
        role.forEach((role1) -> {
            this.roleRepo.save(role1);
        });
        return "success";
    }

    @GetMapping(value = "/user-save")
    public String saveUser(){
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(2L));
        User user = new User("arefin", "arefinsafayat92@gmail.com", "01788857672", "Safayat Arefin", new Date(), true, UUID.randomUUID().toString(), roles);
        user.setPassword(passwordEncoder.encode("123"));
        userRepo.save(user);
        return "success";
    }
}
