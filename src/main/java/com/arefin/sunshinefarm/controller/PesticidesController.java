package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Insecticides;
import com.arefin.sunshinefarm.entity.Pesticides;
import com.arefin.sunshinefarm.repo.CropsRepo;
import com.arefin.sunshinefarm.repo.InsecticidesRepo;
import com.arefin.sunshinefarm.repo.PesticidesRepo;
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
@RequestMapping(value = "/pesticides/")
public class PesticidesController {
    @Autowired
    public PesticidesRepo pesticidesRepo;

    @Autowired
    public CropsRepo cropsRepo;

    @GetMapping(value = "create")
    public String addInsecticidesView(Model model) {
        model.addAttribute("pesticides", new Pesticides());
        model.addAttribute("croplist", this.cropsRepo.findAll());
        return "pesticides/create";
    }

    @PostMapping(value = "create")
    public String addInsecticides(@Valid Pesticides pesticides, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "pesticides/create";
        }
        this.pesticidesRepo.save(pesticides);
        model.addAttribute("successpesticides", "Save pesticides Success");
        model.addAttribute("pesticides", new Pesticides());
        model.addAttribute("croplist", this.cropsRepo.findAll());
        return "pesticides/create";
    }

    @GetMapping(value = "update/{id}")
    public String editInsecticidesView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("pesticides", this.pesticidesRepo.getOne(id));
        model.addAttribute("croplist", this.cropsRepo.findAll());
        return "pesticides/update";
    }

    @PostMapping(value = "update/{id}")
    public String editInsecticides(@Valid Pesticides pesticides, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "pesticides/update";
        }
        this.pesticidesRepo.save(pesticides);
        model.addAttribute("pesticides", new Pesticides());
        model.addAttribute("croplist", this.cropsRepo.findAll());
        return "redirect:/pesticides/list";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.pesticidesRepo.deleteById(id);
        }
        return "redirect:/pesticides/list";
    }

    @GetMapping(value = "list")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pesticideslist", pesticidesRepo.findAll());
        this.pesticidesRepo.findAll().forEach((c) -> {
            System.out.println(c.toString());
        });
        modelAndView.setViewName("pesticides/list");
        return modelAndView;
    }
}
