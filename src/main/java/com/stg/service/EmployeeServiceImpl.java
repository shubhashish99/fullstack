package com.stg.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import com.stg.entity.Employees;
import com.stg.exception.EmployeesException;
import com.stg.repository.EmployeesRepository;

public class EmployeeServiceImpl implements EmployeesService {

	@Autowired
	private EmployeesRepository employeesRepository;

	@Override
	public Employees checkCEmployee(UUID employeeId, String employeeName) {
		Employees employees = employeesRepository.findByEmpIdAndEmpName(employeeId, employeeName);

		if (employees == null) {
			throw new EmployeesException("Employee not found!");
		} else {
			return employees;
		}
	}

	@Override
	public List<Employees> fetchEmployeesList() {

		return employeesRepository.findAll();
	}

	@Override
	public Employees addEmployee(Employees employees) {

		return employeesRepository.save(employees);
	}

	@Override
	public List<Employees> searchByIdAndEmpName(UUID employeeId, String employeeName) {

		return (List<Employees>) employeesRepository.findByEmpIdAndEmpName(employeeId, employeeName);
	}

	@Override
	public Employees updateEmployee(Employees employees) {

		return employeesRepository.save(employees);
	}

	@Override
	public void deleteByEmployeeId(UUID employeeId) {
		employeesRepository.deleteByEmployeeId(employeeId);

	}

}
