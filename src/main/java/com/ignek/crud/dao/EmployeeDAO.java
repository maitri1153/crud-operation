package com.ignek.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ignek.crud.connection.DBConnection;
import com.ignek.crud.constant.EmployeeConstant;
import com.ignek.crud.dto.Employee;
 
public class EmployeeDAO {

	protected static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DBConnection.initializeDatabase();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void insertEmployee(Employee employee) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(EmployeeConstant.INSERT)) {
			preparedStatement.setString(1, employee.getFullName());
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setString(3, employee.getGender());
			preparedStatement.setString(4, employee.getDob());
			preparedStatement.setString(5, employee.getHobby());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteEmployee(int emp_id) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(EmployeeConstant.DELETE);) {
			statement.setInt(1, emp_id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Employee> selectAllEmployees() {
		List<Employee> employeelist = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(EmployeeConstant.SELECT_USERS);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(EmployeeConstant.ID);
				String name = rs.getString(EmployeeConstant.NAME);
				String email = rs.getString(EmployeeConstant.EMAIL);
				String gender = rs.getString(EmployeeConstant.GENDER);
				String dob = rs.getString(EmployeeConstant.DOB);
				String hobby = rs.getString(EmployeeConstant.HOBBY);
				employeelist.add(new Employee(id, name, email, gender, dob, hobby));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeelist;
	}
	
	
	 public static void updateEmployee(Employee employee) throws SQLException {
	        try (Connection connection = DBConnection.initializeDatabase(); 
	        		PreparedStatement statement = connection.prepareStatement(EmployeeConstant.UPDATE);) {
	            statement.setString(1, employee.getFullName());
	            statement.setString(2, employee.getEmail());
	            statement.setString(3, employee.getGender());
	            statement.setString(4, employee.getDob());
	            statement.setString(5, employee.getHobby());
	            statement.setInt(6, employee.getId());
	            statement.executeUpdate();
	        }
	    }
}
