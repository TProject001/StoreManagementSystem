package com.example.basic.dao;

import java.util.List;

import com.example.basic.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class EmpDaoImpl implements EmpDao{
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sample1");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = entityManager.getTransaction();
	@Override
	public String addEmployee(Employee employee) {
		try {
//			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sample1");
//			EntityManager entityManager = entityManagerFactory.createEntityManager();
//			EntityTransaction entityTransaction = entityManager.getTransaction();
			
			entityTransaction.begin();
			entityManager.persist(employee);
			entityTransaction.commit();
			
//			entityManager.close();
//			entityManagerFactory.close();
			return "Employee Data save successfully!";
		}catch(Exception e) {
			System.out.println("Error occured");
			return "";
		}
		finally {
			
		}
	}

	@Override
	public Employee getEmployeeData(String empId) {
		Employee employee = entityManager.find(Employee.class, empId);
		return employee;
	}

	@Override
	public String deleteEmployee(String empId) {
		Employee employee = entityManager.find(Employee.class, empId);
		entityTransaction.begin();
		entityManager.remove(employee);
		entityTransaction.commit();
		return "Employee Details deleted successfully!";
	}

	@Override
	public String updateEmployeeName(String empId,String empNewName) {
		Employee employee = entityManager.find(Employee.class,empId );
		entityTransaction.begin();
		employee.setEmpName(empNewName);
		entityTransaction.commit();
		return "Employee name updated successfully";
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		String jpql="SELECT e FROM Employee e"; // OR               "FROM Employee e"
		Query q = entityManager.createQuery(jpql);
		List<Employee> allEmployeeDetails = q.getResultList();
		return allEmployeeDetails;
	}

}
