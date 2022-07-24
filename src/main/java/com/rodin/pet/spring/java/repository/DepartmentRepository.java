package com.rodin.pet.spring.java.repository;

import com.rodin.pet.spring.java.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findDepartmentByDepartmentName(String departmentName);

    Department findDepartmentByDepartmentNameIgnoreCase(String departmentName);

    Department findDepartmentByDepartmentAddressIgnoreCase(String departmentAddress);

    Department findDepartmentByDepartmentCodeIgnoreCase(String departmentCode);
}
