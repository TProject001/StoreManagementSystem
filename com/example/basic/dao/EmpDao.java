package com.example.basic.dao;

import java.util.List;

import com.example.basic.entity.Employee;

public interface EmpDao {
	String addEmployee(Employee employee);
	Employee getEmployeeData(String empId);
	String deleteEmployee(String empId);
	String updateEmployeeName(String empId,String empNewName);
	List<Employee> getAllEmployeeDetails();
}
