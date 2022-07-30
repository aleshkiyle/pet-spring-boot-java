package com.rodin.pet.spring.java.controller;

import com.rodin.pet.spring.java.entity.Department;
import com.rodin.pet.spring.java.error.DepartmentNotFoundException;
import com.rodin.pet.spring.java.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {


    private static final Logger LOGGER
            = LoggerFactory.getLogger(DepartmentController.class);

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        departmentService.deleteDepartmentById(departmentId);
        return "Department with id " + departmentId + " successfully!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }

    @GetMapping("/departments/address/{address}")
    public Department fetchDepartmentByAddress(@PathVariable("address") String departmentAddress) {
        return departmentService.fetchDepartmentByAddress(departmentAddress);
    }

    @GetMapping("/departments/code/{code}")
    public Department fetchDepartmentByCode(@PathVariable("code") String departmentCode) {
        return departmentService.fetchDepartmentByCode(departmentCode);
    }
}
