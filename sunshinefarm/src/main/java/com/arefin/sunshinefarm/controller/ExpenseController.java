package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Designation;
import com.arefin.sunshinefarm.entity.Expenses;
import com.arefin.sunshinefarm.repo.DesignationRepo;
import com.arefin.sunshinefarm.repo.ExpenseRepo;
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

@Controller
@RequestMapping(value = "/expenses/")
public class ExpenseController {
    @Autowired
    private ExpenseRepo expenseRepo;

    @GetMapping(value = "create")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj", new Expenses());
        modelAndView.setViewName("expenses/create");
        return modelAndView;
    }

    @PostMapping(value = "create")
    public ModelAndView save(@Valid Expenses obj, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if(result.hasErrors()){
            modelAndView.setViewName("expenses/create");
            return modelAndView;
        }
        obj.setDate(new Date());
        if (obj != null) {
            expenseRepo.save(obj);
            modelAndView.addObject("obj", new Expenses());
            modelAndView.addObject("successExpense", "Successfully Expense inserted");
            modelAndView.setViewName("expenses/create");
        }
        modelAndView.setViewName("expenses/create");
        return modelAndView;
    }

    @GetMapping(value = "update/{id}")
    public String editExpensesView(@PathVariable("id") Long id, Model model){
        model.addAttribute("obj", this.expenseRepo.getOne(id));
        return "expenses/update";
    }

    @PostMapping(value = "update/{id}")
    public String editExpenses(@Valid Expenses expenses, BindingResult bindingResult, @PathVariable("id") Long id, Model model){
        if (bindingResult.hasErrors()){
            return "expenses/update";
        }
        expenses.setDate(new Date());
        if (expenses != null){
            this.expenseRepo.save(expenses);
            model.addAttribute("expenses", new Expenses());
        }
        return "redirect:/expenses/list";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.expenseRepo.deleteById(id);
        }
        return "redirect:/expenses/list";
    }

    @GetMapping(value = "list")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", expenseRepo.findAll());
        modelAndView.setViewName("expenses/list");
        return modelAndView;
    }
}
