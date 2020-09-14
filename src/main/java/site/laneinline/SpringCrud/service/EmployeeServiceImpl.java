package site.laneinline.SpringCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		//TODO PROBLEM create NEW Employee if ID is null without any warnings 
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
	
	@Override
	public void delete(long id) {
		this.employeeRepository.deleteById(id);
		
	}
	
	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : 
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo- 1, pageSize, sort);
		return this.employeeRepository.findAll(pageable);
	}
	
	

}
