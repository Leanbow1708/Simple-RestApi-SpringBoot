package com.example.spring.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.spring.demo.entity.Department;
import com.example.spring.demo.repository.DepartmentRespository;
@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRespository departmentRespository;
	
	@BeforeEach
	void setUp() throws Exception {
		Department department = new Department(1L, "Computer", "Rajkot", "CE-FOT-1");
		Mockito.when(departmentRespository.findByDeptName("Computer"))
				.thenReturn(department);
		
	}

	@Test
	@DisplayName("Validate if Department Service is working properly")
	public void ifValidDepartmentName_thenFetchDepartment() {
		
		String deptName = "Computer";
		Department department = departmentService.getDepartmentByDeptName(deptName);
		assertEquals(deptName,department.getDeptName());
		
	}
	
}
