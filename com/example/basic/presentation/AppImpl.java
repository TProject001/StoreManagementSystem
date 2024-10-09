package com.example.basic.presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.example.basic.dao.EmpDao;
import com.example.basic.dao.EmpDaoImpl;
import com.example.basic.entity.Employee;

public class AppImpl implements App {
	
	private Scanner scanner = new Scanner(System.in);
	private EmpDao empDao = new EmpDaoImpl();
	
	@Override
	public void addEmployee() {
		System.out.print("Enter Employee Id : ");
		String empId = scanner.next();
		System.out.print("Enter Employee Name : ");
		String empName = scanner.next();
		System.out.print("Enter Employee salary : ");
		double empSalary = scanner.nextDouble();
		
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setEmpName(empName);
		employee.setEmpSalary(empSalary);
		
//		EmpDao empDao = new EmpDaoImpl();
		System.out.println(empDao.addEmployee(employee));	
	}
	@Override
	public void getEmployeeData() {
		System.out.print("Enter employee Id to get the employee data : ");
		String empId = scanner.next();
		
		Employee employee =  empDao.getEmployeeData(empId);
		if(employee==null) {
			System.out.println("Employee data not found");
		}else {
			System.out.println("*********** Employee Data *********");
			System.out.println("Employee Id     : "+employee.getEmpId());
			System.out.println("Employee Name   : "+employee.getEmpSalary());
			System.out.println("Employee Salary : "+employee.getEmpSalary());
		}
	}
	@Override
	public void updateEmployeeName() {
		System.out.print("Enter employee Id : ");
		String empId = scanner.next();
		System.out.print("Enter employee updated Name : ");
		String empName = scanner.next();
		
		System.out.println( empDao.updateEmployeeName(empId, empName));
	}
	@Override
	public void deleteEmployeeDetails() {
		System.out.print("Enter employee Id : ");
		String empId = scanner.next();
		
		System.out.println(empDao.deleteEmployee(empId));
	}
	@Override
	public void getAllEmployeeDetails() {
		List<Employee> allEmpDetails = empDao.getAllEmployeeDetails();
		if(allEmpDetails==null) {
			System.out.println("Employee details is empty.");
			return;
		}
		Iterator<Employee> itr = allEmpDetails.iterator();
		while(itr.hasNext()) {
			Employee employee = itr.next();
			System.out.println("No     : "+employee.getEmpId());
			System.out.println("Name   : "+employee.getEmpName());
			System.out.println("Salary : "+employee.getEmpSalary()+"\n");
		}
	}

}
