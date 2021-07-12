package com.example.spring.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.spring.demo.entity.Department;
import com.example.spring.demo.error.DepartmentNotFoundException;


public interface DepartmentService {

	public Department saveDepartment(@RequestBody Department department);
	public List<Department> getDepartments();
	public Department getDepartmentById(Long id) throws DepartmentNotFoundException;
	public void deleteDepartmentById(Long id);
	public Department getDepartmentByDeptName(String name);
}