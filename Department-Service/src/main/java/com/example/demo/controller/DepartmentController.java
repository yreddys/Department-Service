package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	private DepartmentService service;

	@Autowired
	DepartmentController(DepartmentService service) {
		this.service = service;
	}

	@PostMapping("/save")

	String saveDepartment(@RequestBody Department department) {
		service.savingDepartment(department);

		return "Data saved Successfully :" + department.getDepartment_id();

	}

	@GetMapping("/getAll")

	List<Department> getAllData() {

		return service.getAllData();
	}
}
