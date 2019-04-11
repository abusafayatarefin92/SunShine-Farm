package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Role;
import com.arefin.sunshinefarm.entity.User;
import com.arefin.sunshinefarm.image.ImageOptimizer;
import com.arefin.sunshinefarm.repo.RoleRepo;
import com.arefin.sunshinefarm.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    //Save the uploaded file to this folder
    private static final String UPLOADED_FOLDER = "src/main/resources/static/images/";

    @Autowired
    private ImageOptimizer imageOptimizer;

    @GetMapping(value = "create")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj", new User());
        modelAndView.addObject("rolelist", roleRepo.findAll());
        modelAndView.setViewName("user/create");
        return modelAndView;
    }

    @PostMapping(value = "create")
    public ModelAndView save(@Valid User obj, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("user/create");
            return modelAndView;
        }
        if (obj != null) {
            User user = this.userRepo.findByName(obj.getName());
            if (user != null) {
                modelAndView.addObject("existuser", "user is already exist");
            } else {
                obj.setRegistrationDate(new Date());
                obj.setEnabled(true);
                obj.setPassword(passwordEncoder.encode(obj.getPassword()));
                obj.setConfirmationToken(UUID.randomUUID().toString());
                this.userRepo.save(obj);
                modelAndView.addObject("successuser", "Save user Success");
                modelAndView.addObject("obj", new User());
                modelAndView.addObject("rolelist", roleRepo.findAll());
                modelAndView.setViewName("user/create");
            }
        }
        modelAndView.setViewName("user/create");
        return modelAndView;
    }

    @GetMapping(value = "update/{id}")
    public String edituserView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", this.userRepo.getOne(id));
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "user/update";
    }

    @PostMapping(value = "update/{id}")
    public String editUser(@Valid User user, BindingResult bindingResult, @PathVariable("id") Long id, Model model, @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            return "user/update";
        }
        try {
            //////////////////////For Image Upload start /////////////////////
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

            Files.write(path, bytes);
            user.setFileName("new-" + file.getOriginalFilename());
            user.setFileSize(file.getSize());
            user.setFilePath("images/" + "new-" + file.getOriginalFilename());
            user.setFileExtension(file.getContentType());
            //////////////////////For Image Upload end/////////////////////
            this.userRepo.save(user);
            model.addAttribute("user", new User());
            model.addAttribute("rolelist", this.roleRepo.findAll());
            imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 1.0f, 100, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "redirect:/user/list";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.userRepo.deleteById(id);
        }
        return "redirect:/user/list";
    }

    @GetMapping(value = "list")
    public ModelAndView getList() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.findByUserName(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
//        if(user.getRoles().equals()){
            modelAndView.addObject("userlist", this.userRepo.findAll());
//        }else {
//            modelAndView.addObject("userbyusername", this.userRepo.findAllByUserName(user.getUserName()));
//        }
        modelAndView.setViewName("user/list");
        return modelAndView;
    }
}
