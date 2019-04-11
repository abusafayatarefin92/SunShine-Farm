package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.User;
import com.arefin.sunshinefarm.repo.RoleRepo;
import com.arefin.sunshinefarm.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/")
    public String displayDashboard(){
        return "index";
    }

    @GetMapping(value = "/change-password")
    public String changePassword(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "change-password";
    }

    @PostMapping(value = "/change-password")
    public String changePasswordv(User user, Model model){
        if(user.getPassword() == null){
            model.addAttribute("reject", "Wrong");
            return "change-password";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user1 = this.userRepo.findByUserName(auth.getName());
        user1.setPassword(passwordEncoder.encode(user1.getPassword()));
        this.userRepo.save(user1);
        model.addAttribute("user", new User());
        model.addAttribute("rolelist", this.roleRepo.findAll());
        model.addAttribute("success", "Password Successfully updated");
        return "change-password";
    }

}
