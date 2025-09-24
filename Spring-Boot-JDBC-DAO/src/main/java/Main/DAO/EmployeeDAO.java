package Main.DAO;

import java.util.List;

import Main.Model.Employee;

public interface EmployeeDAO {
	
	int save(Employee emp);
	int update(Employee emp);
	int delete(int id);
	Employee getById(int id);
	List<Employee> getAll();

}
