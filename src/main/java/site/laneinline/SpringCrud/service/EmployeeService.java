package site.laneinline.SpringCrud.service;

import java.util.List;

import site.laneinline.SpringCrud.model.Employee;

public interface EmployeeService {
	
	Employee getById(Long id);
	List<Employee> getAll();
	
	void add(Employee employee);
	void update(Employee employee);

	
	
}
