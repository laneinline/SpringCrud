package site.laneinline.SpringCrud.service;

import java.util.List;

import site.laneinline.SpringCrud.model.Employee;

public interface EmployeeService {
	List<Employee> getAll();
	
	void add(Employee employee);
	
	
}
