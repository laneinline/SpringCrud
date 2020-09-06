package site.laneinline.SpringCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import site.laneinline.SpringCrud.model.Employee;
import site.laneinline.SpringCrud.service.EmployeeService;
import site.laneinline.SpringCrud.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	//display list of employees
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAll() );
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "new_employee"; 
		
	}
	
	@PostMapping("/saveEmployee")
	public String SaveEmployee(@ModelAttribute("employee") Employee employee) {
		System.out.println(employee);
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
	
	
}
