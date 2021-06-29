package com.example.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.Employee;

@RestController
public class EmployeeController {
	private List<Employee> Employees = new ArrayList<Employee>();

	@PostMapping("/employee")
	public Employee create(@RequestBody Employee Employee) {
		Employees.add(Employee);

		return Employee;
	}

	@GetMapping("/employees")
	public List<Employee> getAll() {
		return Employees;
	}
	
	@DeleteMapping("/employee") 
	public void delete(@RequestParam(name="id") int id) {
		for (int i = 0; i < Employees.size() ; i++) {
			if (Employees.get(i).getId() == id) {
				Employees.remove(i);
				break;
			}
		}
	}
	
	@PutMapping("/employee")
	public void update(@RequestBody Employee Employee) {
		for (int i = 0; i < Employees.size() ; i++) {
			if (Employees.get(i).getId() == Employee.getId()) {
				Employees.set(i, Employee);
				break;
			}
		}
	}
	
}
