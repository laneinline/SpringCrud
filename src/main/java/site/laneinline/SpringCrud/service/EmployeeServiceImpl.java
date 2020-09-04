package site.laneinline.SpringCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import site.laneinline.SpringCrud.model.Employee;
import site.laneinline.SpringCrud.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAll() {
		
		return employeeRepository.findAll();
	}

}
