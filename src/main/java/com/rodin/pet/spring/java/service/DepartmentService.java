package com.rodin.pet.spring.java.service;

import com.rodin.pet.spring.java.entity.Department;
import com.rodin.pet.spring.java.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);

    Department fetchDepartmentByAddress(String departmentAddress);

    Department fetchDepartmentByCode(String departmentCode);
}
