package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.CropsSummary;
import com.arefin.sunshinefarm.entity.Equipment;
import com.arefin.sunshinefarm.entity.Sales;
import com.arefin.sunshinefarm.repo.CropsRepo;
import com.arefin.sunshinefarm.repo.CropsSummaryRepo;
import com.arefin.sunshinefarm.repo.EquipmentRepo;
import com.arefin.sunshinefarm.repo.SalesRepo;
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

@Controller
@RequestMapping(value = "/sales/")
public class SalesController {
    @Autowired
    public SalesRepo salesRepo;

    @Autowired
    public CropsRepo cropsRepo;

    @Autowired
    public CropsSummaryRepo cropsSummaryRepo;

    @GetMapping(value = "create")
    public String addSalesView(Model model){
        model.addAttribute("sales", new Sales());
        model.addAttribute("cropslist", this.cropsRepo.findAll());
        return "sales/create";
    }

    @PostMapping(value = "create")
    public String addSales(@Valid Sales sales, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "sales/create";
        }
        try{
            CropsSummary cropsSummary = this.cropsSummaryRepo.findByProductCode(sales.getProductCode());
            if(sales.getQuantity() <= cropsSummary.getAvailableQuantity()){
                sales.setSalesDate(new Date());
                this.salesRepo.save(sales);
                model.addAttribute("sales", new Sales());
                model.addAttribute("successsales", "Sales successfully added");
                model.addAttribute("cropslist", this.cropsRepo.findAll());

                int availableQuantity = cropsSummary.getAvailableQuantity() - sales.getQuantity();
                cropsSummary.setAvailableQuantity(availableQuantity);
                int salesQuantity = cropsSummary.getSalesQuantity() + sales.getQuantity();
                cropsSummary.setSalesQuantity(salesQuantity);
                cropsSummary.setLastUpdate(new Date());
                cropsSummaryRepo.save(cropsSummary);
            }else{
                model.addAttribute("rejectMsg", "You don't have sufficient Quantity");
                model.addAttribute("cropslist", this.cropsRepo.findAll());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "sales/create";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.salesRepo.deleteById(id);
        }
        return "redirect:/sales/list";
    }

    @GetMapping(value = "list")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("saleslist", salesRepo.findAll());
        this.salesRepo.findAll().forEach((c) -> {
            System.out.println(c.toString());
        });
        modelAndView.setViewName("sales/list");
        return modelAndView;
    }
}
