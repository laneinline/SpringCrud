package site.laneinline.SpringCrud.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

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
	
	@Override
	public void update(Employee employee) {
		this.employeeRepository.save(employee);
		
	}
	
	@Override
	public Employee getById(Long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new  RuntimeException("Employee is not found for id" + id);
		}
		return employee;
	}
	
	// TODO another todo

}
