package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Employees;
import com.arefin.sunshinefarm.entity.User;
import com.arefin.sunshinefarm.repo.DesignationRepo;
import com.arefin.sunshinefarm.repo.EmployeesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value = "/employees/")
public class EmployeesController {
    @Autowired
    public EmployeesRepo employeesRepo;

    @Autowired
    public DesignationRepo designationRepo;

    @GetMapping(value = "create")
    public String addEmployeesView(Model model) {
        model.addAttribute("employees", new Employees());
        model.addAttribute("designationlist", this.designationRepo.findAll());
        return "employees/create";
    }

    @PostMapping(value = "create")
    public String addEmployees(@Valid Employees employees, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "employees/create";
        }
        employees.setStartingDate(new Date());
        this.employeesRepo.save(employees);
        model.addAttribute("successemployees", "Save employee Success");
        model.addAttribute("employees", new Employees());
        model.addAttribute("designationlist", this.designationRepo.findAll());
        return "employees/create";
    }

    @GetMapping(value = "update/{id}")
    public String edituserView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("employees", this.employeesRepo.getOne(id));
        model.addAttribute("designationlist", this.designationRepo.findAll());
        return "employees/update";
    }

    @PostMapping(value = "update/{id}")
    public String editUser(@Valid Employees employees, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "employees/update";
        }
        this.employeesRepo.save(employees);
        model.addAttribute("employees", new Employees());
        model.addAttribute("designationlist", this.designationRepo.findAll());
        return "redirect:/employees/list";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.employeesRepo.deleteById(id);
        }
        return "redirect:/employees/list";
    }

    @GetMapping(value = "list")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employeeslist", employeesRepo.findAll());
        this.employeesRepo.findAll().forEach((c) -> {
            System.out.println(c.toString());
        });
        modelAndView.setViewName("employees/list");
        return modelAndView;
    }
}
