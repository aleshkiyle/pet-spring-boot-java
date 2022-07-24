package com.rodin.pet.spring.java.controller;

import com.rodin.pet.spring.java.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebDepartmentController {

    private final DepartmentService departmentService;

    public WebDepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping(value = "/")
    public String getDepartments(Model model) {
        model.addAttribute("departments", departmentService.fetchDepartmentList());
        return "departments";
    }
}
