package com.example.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.demo.entity.Department;

@Repository
public interface DepartmentRespository extends JpaRepository<Department, Long>{

	Department findByDeptName(String name);

}
