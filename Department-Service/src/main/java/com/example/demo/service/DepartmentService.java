package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;

public interface DepartmentService {

	Department savingDepartment(Department department);

	List<Department> getAllData();

}
