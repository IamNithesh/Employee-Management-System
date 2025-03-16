package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping
	public String showAllEmployees (Model model) {
		model.addAttribute("employees", service.getAllEmployees());
		return "list";
	}
	
	@GetMapping("/add")
	public String addEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "add";
	}
	
	@PostMapping("/add")
	public String saveEmployee(@ModelAttribute Employee employee) {		
		service.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id,Model model) {
		model.addAttribute("employee", service.getEmployeeById(id));
		return "edit";
	}
	
	@PostMapping("/edit/{id}")
	public String updateEmployee(@PathVariable Long id,Model model,
			@ModelAttribute Employee employee) {
		employee.setId(id);
		service.saveEmployee(employee);
		return "redirect:/employees";		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Long id,Model model) {
		
		service.deleteEmployee(id);
		return "redirect:/employees";		
	}

}
