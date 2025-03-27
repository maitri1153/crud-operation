package com.ignek.crud.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ignek.crud.constant.Constant;

public class DBConnection {
	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
		
		Class.forName(Constant.DRIVER);
		Connection connection = DriverManager.getConnection(Constant.PATH,Constant.USERID,Constant.PASSWORD);
		return connection;
	}
}
