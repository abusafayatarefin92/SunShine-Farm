package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.repo.CropsSummaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/crops-summary/")
public class CropsSummaryController {
    @Autowired
    private CropsSummaryRepo cropsSummaryRepo;

    @GetMapping(value = "list")
    public String getList(Model model){
        model.addAttribute("cropssummarylist", this.cropsSummaryRepo.findAll());
        return "crops-summary/list";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id){
        if (id != null){
            this.cropsSummaryRepo.deleteById(id);
        }
        return "redirect:/crops-summary/list";
    }
}
