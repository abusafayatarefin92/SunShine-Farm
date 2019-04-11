package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Designation;
import com.arefin.sunshinefarm.entity.User;
import com.arefin.sunshinefarm.repo.DesignationRepo;
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
@RequestMapping(value = "/designation/")
public class DesignationController {
    @Autowired
    DesignationRepo designationRepo;

    @GetMapping(value = "create")
    public String displayDesignation(Model model) {
        model.addAttribute("obj", new Designation());
        return "designation/create";
    }

    @PostMapping(value = "create")
    public String saveDesignation(@Valid Designation obj, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "designation/create";
        }
        designationRepo.save(obj);
        model.addAttribute("successMsg", "Success");
        model.addAttribute("obj", new Designation());
        return "designation/create";
    }

    @GetMapping(value = "update/{id}")
    public String editDesignationView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("designation", this.designationRepo.getOne(id));
        return "designation/update";
    }

    @PostMapping(value = "update/{id}")
    public String editDesignation(@Valid Designation designation, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "designation/update";
        }
        this.designationRepo.save(designation);
        model.addAttribute("designation", new Designation());
        return "redirect:/designation/list";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.designationRepo.deleteById(id);
        }
        return "redirect:/user/list";
    }

    @GetMapping(value = "list")
    public String getRoleList(Model model) {
        model.addAttribute("list", designationRepo.findAll());
        return "designation/list";
    }
}
