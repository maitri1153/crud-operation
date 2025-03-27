package com.ignek.crud.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.ignek.crud.connection.DBConnection;
import com.ignek.crud.dto.Employee;



public class DAOEmployee {
	
	private static String INSERT_USERS_SQL = "INSERT into Employee(name,email,gender,dob,hobby)values(?,?,?,?,?)";
	
	
	
	protected static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DBConnection.initializeDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
	
	
	
	public static void insertUser(Employee employee) throws SQLException {
        try (Connection connection = getConnection();
        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, employee.getFullName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setString(4, employee.getDob());
            preparedStatement.setString(5, employee.getHobby());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
