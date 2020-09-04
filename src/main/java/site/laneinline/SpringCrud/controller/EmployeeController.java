package site.laneinline.SpringCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import site.laneinline.SpringCrud.service.EmployeeService;

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
}
