package com.ignek.crud.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.ignek.crud.constant.EmployeeConstant;

public class DBConnection {
	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
		Connection connection = null;
		try {
			Class.forName(EmployeeConstant.DRIVER);
			connection = DriverManager.getConnection(EmployeeConstant.PATH, EmployeeConstant.USER_ID, 
					EmployeeConstant.PASSWORD);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
