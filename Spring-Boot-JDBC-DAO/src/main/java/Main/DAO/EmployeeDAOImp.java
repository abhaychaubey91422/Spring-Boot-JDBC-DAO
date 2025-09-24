package Main.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Main.Model.Employee;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(Employee emp) {
		String sql = "Insert into employee values(?,?,?)";
		return jdbcTemplate.update(sql, emp.getId(), emp.getName(), emp.getSalary());
		
	}

	@Override
	public int update(Employee emp) {
		String s = "Update employee set name = ?, salary= ? where id=?";
		return jdbcTemplate.update(s, emp.getId(), emp.getName(), emp.getSalary());
	}

	@Override
	public int delete(int id) {
		String sql1 = "Delete from employee where id=?";
		return jdbcTemplate.update(sql1, id);
	}

	@Override
	public Employee getById(int id) {
		String sql = "Select * From employee where id=?";
		return jdbcTemplate.queryForObject(sql, (rs, rowNum)-> mapRow(rs), id);
	}

	@Override
	public List<Employee> getAll() {
		String sql = "Select * from employee";
		return jdbcTemplate.query(sql,  (rs, rowNum)-> mapRow(rs));
	}
	
	private Employee mapRow(ResultSet rs) throws SQLException
	{
		Employee emp = new Employee();
		emp.setId(rs.getInt("id"));
		emp.setName(rs.getString("name"));
		emp.setSalary(rs.getDouble("salary"));
		
		return emp;
	}

}
