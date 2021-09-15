package com.revature.service;

import java.util.List;
import java.util.Optional;

import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;

public class EmployeeService {
	
	private EmployeeDao edao;
	
	public EmployeeService(EmployeeDao dao) {
		super();
		this.edao = dao;
	}
	
	public Employee confirmLogin(String username, String password) {
		Optional<Employee> emp = edao.findAll()
				.stream()
				.filter(e -> (e.getUsername().equals(username) && e.getPassword().equals(password)))
				.findFirst();
		
		return (emp.isPresent() ? emp.get() : null);
	}
	
	
	
	
	public int insert(Employee e) {
		return edao.insert(e);
	}
	
	public boolean update(Employee e) {
		return edao.update(e);
	}
	
	public boolean delete(Employee e) {
		return edao.delete(e);
	}

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return edao.findAll();
	}
	
	
}
