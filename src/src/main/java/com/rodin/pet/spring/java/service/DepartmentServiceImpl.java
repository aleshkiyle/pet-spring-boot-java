package com.rodin.pet.spring.java.service;

import com.rodin.pet.spring.java.entity.Department;
import com.rodin.pet.spring.java.error.DepartmentNotFoundException;
import com.rodin.pet.spring.java.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department =
                departmentRepository.findById(departmentId);
        if (department.isEmpty()) {
            throw new DepartmentNotFoundException("Department not available!");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department departmentDB = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())) {
            departmentDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            departmentDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            departmentDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(departmentDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findDepartmentByDepartmentNameIgnoreCase(departmentName);
    }

    @Override
    public Department fetchDepartmentByAddress(String departmentAddress) {
        return departmentRepository.findDepartmentByDepartmentAddressIgnoreCase(departmentAddress);
    }

    @Override
    public Department fetchDepartmentByCode(String departmentCode) {
        return departmentRepository.findDepartmentByDepartmentCodeIgnoreCase(departmentCode);
    }
}
