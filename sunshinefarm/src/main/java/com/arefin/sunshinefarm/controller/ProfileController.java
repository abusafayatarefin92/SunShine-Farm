package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.User;
import com.arefin.sunshinefarm.repo.RoleRepo;
import com.arefin.sunshinefarm.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller

public class ProfileController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/profile")
    public String edituserView(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUserName(auth.getName());
        model.addAttribute("user", user);
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "profile";
    }

//   @PostMapping(value = "/profile")
//    public String editUser(@Valid User user, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            return "user/update";
//        }
//        Optional<User> user1 = this.userRepo.findByEmail(user.getEmail());
//        if (user1.get().getId() != id) {
//            model.addAttribute("existuser", "Already Have This Entry");
//             return "user/update";
//        } else {
//            this.userRepo.save(user);
//            model.addAttribute("user", new User());
//            model.addAttribute("successprofile", "Profile Successfully updated");
//            model.addAttribute("rolelist", this.roleRepo.findAll());
//        }
//        return "profile";
//    }
}
