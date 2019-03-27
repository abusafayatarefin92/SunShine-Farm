package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Equipment;
import com.arefin.sunshinefarm.entity.Insecticides;
import com.arefin.sunshinefarm.repo.CropsRepo;
import com.arefin.sunshinefarm.repo.EquipmentRepo;
import com.arefin.sunshinefarm.repo.InsecticidesRepo;
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
import java.util.Optional;

@Controller
@RequestMapping(value = "/insecticides/")
public class InsecticidesController {
    @Autowired
    public InsecticidesRepo insecticidesRepo;

    @Autowired
    public CropsRepo cropsRepo;

    @GetMapping(value = "create")
    public String addInsecticidesView(Model model) {
        model.addAttribute("insecticides", new Insecticides());
        model.addAttribute("croplist", this.cropsRepo.findAll());
        return "insecticides/create";
    }

    @PostMapping(value = "create")
    public String addInsecticides(@Valid Insecticides insecticides, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "insecticides/create";
        }
        this.insecticidesRepo.save(insecticides);
        model.addAttribute("successinsecticides", "Save insecticides Success");
        model.addAttribute("insecticides", new Insecticides());
        model.addAttribute("croplist", this.cropsRepo.findAll());
        return "insecticides/create";
    }

    @GetMapping(value = "update/{id}")
    public String editInsecticidesView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("insecticides", this.insecticidesRepo.getOne(id));
        model.addAttribute("croplist", this.cropsRepo.findAll());
        return "insecticides/update";
    }

    @PostMapping(value = "update/{id}")
    public String editInsecticides(@Valid Insecticides insecticides, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "insecticides/update";
        }
        this.insecticidesRepo.save(insecticides);
        model.addAttribute("insecticides", new Insecticides());
        model.addAttribute("croplist", this.cropsRepo.findAll());
        return "redirect:/insecticides/list";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.insecticidesRepo.deleteById(id);
        }
        return "redirect:/insecticides/list";
    }

    @GetMapping(value = "list")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("insecticideslist", insecticidesRepo.findAll());
        this.insecticidesRepo.findAll().forEach((c) -> {
            System.out.println(c.toString());
        });
        modelAndView.setViewName("insecticides/list");
        return modelAndView;
    }
}
