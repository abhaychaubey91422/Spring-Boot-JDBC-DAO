package Main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Main.Model.Employee;
import Main.Service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping
	public String saveEmployee(@RequestBody Employee emp)
	{
		service.addEmployee(emp);
		return "Employye added Seccessfully!";
	}
	
	@GetMapping
	public List<Employee> getEmployee()
	{
		return service.getAllEmployee();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id)
	{
		return service.getEmployeeById(id);
	}
	
	@PutMapping
	public String updateEmployee(@RequestBody Employee emp)
	{
		 service.updateEmployee(emp);
		 return "Employee updated Successfully";
	}
 
	@DeleteMapping
	public String deleteEmployee(@PathVariable int id)
	{
		service.deleteEmployee(id);
		return "Employee deleted Sucessfully!";
	}
}
