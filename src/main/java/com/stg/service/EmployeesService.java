package com.stg.service;

import java.util.List;
import java.util.UUID;

import com.stg.entity.Employees;

public interface EmployeesService {

	public abstract Employees checkCEmployee(UUID employeeId, String employeeName); // validation

	public abstract List<Employees> fetchEmployeesList(); // read

	public abstract Employees addEmployee(Employees employees); // add

	public abstract List<Employees> searchByIdAndEmpName(UUID employeeId, String employeeName); // search

	public abstract Employees updateEmployee(Employees employees); // update

	public abstract void deleteByEmployeeId(UUID eemployeeId); // delete

}
