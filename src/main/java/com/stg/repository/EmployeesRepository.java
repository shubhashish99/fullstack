package com.stg.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stg.entity.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

	public Employees findByEmpIdAndEmpName(UUID employeeId, String employeeName);

	public void deleteByEmployeeId(UUID employeeId);

}
