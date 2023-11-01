package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentRepository repo;

	@Autowired
	DepartmentServiceImpl(DepartmentRepository repo) {
		this.repo = repo;
	}

	@Override
	public Department savingDepartment(Department department) {
		log.info("Department saving : {}", department);
		Department savingDepartment = repo.save(department);
		log.info("Department saved : {}", savingDepartment);
		return savingDepartment;
	}

	@Override
	public List<Department> getAllData() {
		List<Department> departments = repo.findAll();
		log.info("Fetched departmentDetails : {}", departments);
		return departments;
	}
}
