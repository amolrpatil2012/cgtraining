package cg.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpUtility {

	String url = "jdbc:mysql://localhost:3306/demo";
	String username = "root";
	String password= "demodemo!";
	
	public void addEmp ( Emp emp)
	{
		try ( Connection con = DriverManager.getConnection(url,username,password))
		{
			String sql = "Insert Into emps Values ( ?,?,?)"; // Parametrized Query
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, emp.getEmpid());
			ps.setString(2, emp.getEmpname());
			ps.setInt(3, emp.getEmpsalary());
			ps.executeUpdate();					// Executes Query
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void deleteEmp ( int empid)
	{
		try ( Connection con = DriverManager.getConnection(url,username,password))
		{
			String sql = "DELETE from emps where empid = ?"; // Parametrized Query
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empid);		
			ps.executeUpdate();					// Executes Query
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void updateEmp ( int empid , Emp newEmp)
	{
		try ( Connection con = DriverManager.getConnection(url,username,password))
		{
			String sql = "Update emps SET empname = ? , empsalary=? WHERE empid=?"; // Parametrized Query
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newEmp.getEmpname());
			ps.setInt(2, newEmp.getEmpsalary());
			ps.setInt(3, empid);
			ps.executeUpdate();					// Executes Query
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	// Find All emps where salary is greater than 20000	
	public List<Emp> findEmpsWithSalaryGreaterThan ( int salary)
	{
		List<Emp> emps = new ArrayList<Emp>();
		
		try ( Connection con = DriverManager.getConnection(url,username,password))
		{
			String sql = "Select * From emps Where empsalary > ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, salary);
			
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next())
			{
				int id = rs.getInt("empid");
				String name = rs.getString("empname");
				int esalary = rs.getInt("empsalary");
				Emp e = new Emp(id, name, esalary);
				emps.add(e);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return emps;
	}

}
