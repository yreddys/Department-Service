package com.example.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentServiceImpl;

@ExtendWith(MockitoExtension.class)
public class testDepartment {
	@Mock
	private DepartmentRepository repo;
	@InjectMocks
	private DepartmentServiceImpl service;

	@Test
	void testData() {
		Department expectedDepartment = new Department();
		expectedDepartment.setDepartment_id(1L);
		expectedDepartment.setDeptName("Hello");
		when(repo.save(expectedDepartment)).thenReturn(expectedDepartment);
		Department actualDepartment = service.savingDepartment(expectedDepartment);

		assertEquals(expectedDepartment, actualDepartment);
		verify(repo, times(1)).save(expectedDepartment);

	}

	@Test
	void testAllData() {
		Department expectedDepartment = new Department();
		expectedDepartment.setDepartment_id(1L);
		expectedDepartment.setDeptName("Hello");

		List<Department> expectedList = Arrays.asList(expectedDepartment);
		when(repo.findAll()).thenReturn(expectedList);
		List<Department> actualDepartment = service.getAllData();
		assertEquals(expectedList, actualDepartment);
		verify(repo, times(1)).findAll();

	}
}
