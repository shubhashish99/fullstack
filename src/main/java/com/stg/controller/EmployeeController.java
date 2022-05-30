package com.stg.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Employees;
import com.stg.service.EmployeesService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeesService employeesService;

	@GetMapping(value = "/checkemployee", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employees> checkCEmployee(@RequestParam UUID employeeId, @RequestParam String employeeName) {

		Employees employees = employeesService.checkCEmployee(employeeId, employeeName);

		return new ResponseEntity<Employees>(employees, HttpStatus.OK);
	}

	@GetMapping(value = "/fetchemployeelist", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employees> fetchEmployeesList() {

		List<Employees> employees = employeesService.fetchEmployeesList();

		return new ResponseEntity<Employees>((Employees) employees, HttpStatus.OK);
	}

	@PostMapping(value = "/addemployee", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employees> addEmployee(@RequestParam Employees employees) {

		Employees employees1 = employeesService.addEmployee(employees);

		return new ResponseEntity<Employees>(employees1, HttpStatus.OK);
	}

	@GetMapping(value = "/searchemployee", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employees> searchByIdAndEmpName(@RequestParam UUID employeeId,
			@RequestParam String employeeName) {

		List<Employees> employees = employeesService.searchByIdAndEmpName(employeeId, employeeName);

		return new ResponseEntity<Employees>((Employees) employees, HttpStatus.OK);
	}

	@PutMapping(value = "/updateemployee", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employees> updateEmployee(@RequestParam Employees employees) {

		Employees employees1 = employeesService.updateEmployee(employees);

		return new ResponseEntity<Employees>(employees1, HttpStatus.OK);
	}

	@DeleteMapping(value = "/updateemployee", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employees> deleteByEmployeeId(@RequestParam UUID employeeId) {

		employeesService.deleteByEmployeeId(employeeId);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
