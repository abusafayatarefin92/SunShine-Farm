package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DashoardController {
    @Autowired
    private CropsRepo cropsRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private CropsSummaryRepo cropsSummaryRepo;

    @Autowired
    private EmployeesRepo employeesRepo;

    @Autowired
    private EquipmentRepo equipmentRepo;

    @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private InsecticidesRepo insecticidesRepo;

    @Autowired
    private PesticidesRepo pesticidesRepo;

    @Autowired
    private SalesRepo salesRepo;

    @Autowired
    private UserRepo userRepo;


}
