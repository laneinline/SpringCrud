package site.laneinline.SpringCrud;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import site.laneinline.SpringCrud.model.Employee;
import site.laneinline.SpringCrud.service.EmployeeServiceImpl;

@SpringBootApplication
public class SpringCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args); 
		
//test
//		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
//		
//		List<Employee> employees = employeeServiceImpl.getAll();
//
//			System.out.println(employees.get(0).toString());

	}

}
