package com.rodin.pet.spring.java.service;

import com.rodin.pet.spring.java.entity.Department;
import com.rodin.pet.spring.java.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DepartmentServiceTest {

    @MockBean
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("TEST")
                        .departmentCode("six")
                        .departmentId(12L)
                        .build();
        Mockito.when(departmentRepository.findDepartmentByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on Valida Department Name")
    @Disabled
    public void whenValidDepartmentName_ThenDepartmentShouldFound() {
        String departmentName = "IT";
        Department foundDepartment =
                departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, foundDepartment.getDepartmentName());
    }
}