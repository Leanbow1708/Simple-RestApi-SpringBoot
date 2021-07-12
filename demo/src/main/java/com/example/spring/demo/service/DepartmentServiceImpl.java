package com.example.spring.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.demo.entity.Department;
import com.example.spring.demo.error.DepartmentNotFoundException;
import com.example.spring.demo.repository.DepartmentRespository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRespository deptRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		return deptRepository.save(department);
	}

	@Override
	public List<Department> getDepartments() {
		return deptRepository.findAll();
	}

	@Override
	public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
		Optional<Department> optional = deptRepository.findById(id);
		if(!optional.isPresent()) {
			throw new DepartmentNotFoundException("Department doesn't exist");
		}
		return optional.get();
	}

	@Override
	public void deleteDepartmentById(Long id) {
		deptRepository.deleteById(id);
	}

	@Override
	public Department getDepartmentByDeptName(String name) {
		return deptRepository.findByDeptName(name);
	}
	

}
