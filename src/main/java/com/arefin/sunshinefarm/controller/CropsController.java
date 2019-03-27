package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Crops;
import com.arefin.sunshinefarm.entity.CropsSummary;
import com.arefin.sunshinefarm.image.ImageOptimizer;
import com.arefin.sunshinefarm.repo.CropsRepo;
import com.arefin.sunshinefarm.repo.CropsSummaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
@RequestMapping(value = "/crops/")
public class CropsController {
    @Autowired
    private CropsRepo cropsRepo;

    @Autowired
    private CropsSummaryRepo cropsSummaryRepo;

    @GetMapping(value = "list")
    public String cropsListView(Model model) {
        model.addAttribute("cropslist", this.cropsRepo.findAll());
        this.cropsRepo.findAll().forEach((crops) -> {
            System.out.println(crops.toString());
        });
        return "crops/list";
    }

    @GetMapping(value = "create")
    public String addCropsView(Model model){
        model.addAttribute("crops", new Crops());
        return "crops/create";
    }

    @PostMapping(value = "create")
    public String addCrops(@Valid Crops crops, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "crops/create";
        }
        this.cropsRepo.save(crops);
        model.addAttribute("crops", new Crops());
        model.addAttribute("successcrops", "Crops Successfully added");
        try{
            CropsSummary cropsSummary = (CropsSummary) this.cropsSummaryRepo.findByProductCode(crops.getProductCode());
            int availableQuantity = cropsSummary.getAvailableQuantity() + crops.getQuantity();
            cropsSummary.setAvailableQuantity(availableQuantity);
            cropsSummary.setLastUpdate(new Date());
            int totalQuantity = cropsSummary.getTotalQuantity() + crops.getQuantity();
            cropsSummary.setTotalQuantity(totalQuantity);
            cropsSummaryRepo.save(cropsSummary);
        }catch (Exception e){
            CropsSummary cropsSummary1 = new CropsSummary();
            cropsSummary1.setProductName(crops.getName());
            cropsSummary1.setProductCode(crops.getProductCode());
            cropsSummary1.setTotalQuantity(crops.getQuantity());
            cropsSummary1.setSalesQuantity(0);
            cropsSummary1.setAvailableQuantity(crops.getQuantity());
            cropsSummary1.setLastUpdate(new Date());
            cropsSummaryRepo.save(cropsSummary1);
        }
        return "crops/create";
    }

    @GetMapping(value = "delete/{id}")
    private String getList(@PathVariable("id") Long id){
        if (id != null) {
            this.cropsRepo.deleteById(id);
        }
        return "redirect:/crops/list";
    }
}
