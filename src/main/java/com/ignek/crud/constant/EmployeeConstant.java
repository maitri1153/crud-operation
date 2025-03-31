package com.ignek.crud.constant;

public class EmployeeConstant {
	public static String PATH = "jdbc:mysql://localhost:3306/company";
	public static String USER_ID = "root";
	public static String PASSWORD = "ignek@12345";
	public static String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static String INSERT ="INSERT into Employee(name,email,gender,dob,hobby) VALUES (?,?,?,?,?);";
	public static String DELETE = "delete from Employee where emp_id=?;";
	public static String SELECT_USERS = "select * from Employee";
	public static String UPDATE = "update Employee set name=?, email=?,gender=?, dob=?,hobby=? where emp_id=?";
	public static String Id = "id";
	public static String ID ="emp_id";
	public static String FULL_NAME = "fullName";
	public static String NAME ="name";
	public static String EMAIL ="email";
	public static String GENDER ="gender";
	public static String DOB ="dob";
	public static String HOBBY ="hobby";
}
