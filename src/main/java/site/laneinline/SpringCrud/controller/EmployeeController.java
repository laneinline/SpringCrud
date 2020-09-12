package site.laneinline.SpringCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import site.laneinline.SpringCrud.model.Employee;
import site.laneinline.SpringCrud.service.EmployeeService;


@Controller
public class EmployeeController {
	//display list of employees
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, model);
		//model.addAttribute("listEmployees", employeeService.getAll() );
		//return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "new_employee"; 
		
	}
	
	@PostMapping("/saveEmployee")
	public String SaveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.add(employee);

		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdateEmployee/{id}")
	public String showFormForUpdateEmployee(@PathVariable(value ="id") long id, Model model){
		//call service to get employee from DB 
		Employee employee = employeeService.getById(id);
		//set employee as model attribute 
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value="id") long id){
		//call delete employee from servise
		
		this.employeeService.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model){
		int pageSize = 5;
		//TODO inplement dif page size
		
		Page<Employee> page = employeeService.findPaginated(pageNo, pageSize);
		List<Employee> listEmployees = page.getContent();
		
		model.addAttribute("currentPageNumber", pageNo);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("totalItems",page.getTotalElements());
		model.addAttribute("listEmployees", listEmployees);
		
		
		return "index";
	}
}
