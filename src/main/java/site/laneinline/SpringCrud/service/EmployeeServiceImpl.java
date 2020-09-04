package site.laneinline.SpringCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.laneinline.SpringCrud.model.Employee;
import site.laneinline.SpringCrud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAll() {
		
		return employeeRepository.findAll();
	}
	@Override
	public void add(Employee employee) {
		this.employeeRepository.save(employee);
		
	}

}
