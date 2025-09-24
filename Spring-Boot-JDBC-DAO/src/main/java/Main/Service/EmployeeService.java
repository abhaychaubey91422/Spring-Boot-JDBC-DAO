package Main.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Main.DAO.EmployeeDAO;
import Main.Model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;
	
	public int addEmployee(Employee emp)
	{
		return employeeDao.save(emp);
	}
	
	public List<Employee> getAllEmployee()
	{
		return employeeDao.getAll();
	}
	
	public Employee getEmployeeById(int id)
	{
		return employeeDao.getById(id);
	}
	
	public int updateEmployee(Employee emp)
	{
		return employeeDao.update(emp);
	}
	
	public int deleteEmployee(int id)
	{
		return employeeDao.delete(id);
	}
}
