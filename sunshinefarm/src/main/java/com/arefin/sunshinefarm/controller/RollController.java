package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Role;
import com.arefin.sunshinefarm.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/role/")
public class RollController {
    @Autowired
    RoleRepo roleRepo;

    @GetMapping(value = "create")
    public String addRoleView(Model model) {
        model.addAttribute("role", new Role());
        return "role/create";
    }

    @PostMapping(value = "create")
    public String addRole(@Valid Role role, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "role/create";
        }
        if (roleRepo.existsRoleByRoleName(role.getRoleName())) {
            model.addAttribute("existrole", "Role already exist");
        } else {
            role.setRoleName(role.getRoleName().toUpperCase());
            this.roleRepo.save(role);
            model.addAttribute("role", new Role());
            model.addAttribute("successrole", "Role Successfully added");
        }
        return "role/create";
    }

    @GetMapping(value = "list")
    public String roleList(Model model) {
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "role/list";
    }


}
