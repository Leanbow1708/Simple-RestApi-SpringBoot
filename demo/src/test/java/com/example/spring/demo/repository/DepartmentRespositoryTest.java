package com.example.spring.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.spring.demo.entity.Department;

@DataJpaTest
class DepartmentRespositoryTest {

	
	@Autowired
	private DepartmentRespository departmentRespository;
	
	@Autowired 
	private TestEntityManager testEntityManager;
	
	@BeforeEach
	void setUp() throws Exception {
		
		Department department = new Department(1L, "Computer", "Rajkot", "CE-FOT-1");
		testEntityManager.persist(department);
	}
	
	@Test
	public void test1() {
		Department department = departmentRespository.getById(1L);
		assertEquals(department.getDeptName(), "Computer");
	}

	

}
