package site.laneinline.SpringCrud.service;

import java.util.List;

import org.springframework.data.domain.Page;

import site.laneinline.SpringCrud.model.Employee;

public interface EmployeeService {
	
	Employee getById(Long id);
	List<Employee> getAll();
	
	void add(Employee employee);
	void update(Employee employee);
	void delete(long id);
	
	Page<Employee> findPaginated(int pageNo, int pageSize, String sortField , String sortDirection); 


	
	
}
