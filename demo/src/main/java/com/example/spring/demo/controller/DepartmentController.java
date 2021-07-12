package com.example.spring.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.demo.entity.Department;
import com.example.spring.demo.error.DepartmentNotFoundException;
import com.example.spring.demo.service.DepartmentService;


@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;
	
	private final Logger LOGGER = 
			org.slf4j.LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		
		return deptService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> getDepartments(){
		LOGGER.info("inside get request of departments");
		return deptService.getDepartments();
	}
	
	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
		return deptService.getDepartmentById(id);
	}
	
	@DeleteMapping("departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long id) {
		
		deptService.deleteDepartmentById(id);
		return "Department Deleted Successfully";
	}
	
	@GetMapping("departments/name/{name}")
	public Department getDepartmentByName(@PathVariable("name") String name){
		return deptService.getDepartmentByDeptName(name);
	}
}
