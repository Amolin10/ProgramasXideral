package com.curso;

import java.sql.*;

public class Principal3 {
	public static void main(String[] args) throws SQLException {
		
		String insertSql = "INSERT INTO student VALUES(10, 'Paco', 'Gomez', 'paco@gmail.com')";
		String updateSql = "UPDATE student SET first_name = 'Pedro' " + "WHERE first_name = 'Paco'";
		String deleteSql = "DELETE FROM student WHERE id = 10";
		
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/web_student_tracker?useSSL=false", 
				"webstudent",
				"webstudent");
			PreparedStatement ps = conn.prepareStatement(insertSql);
		) {
				int result = ps.executeUpdate();
				System.out.println(result);
		} //try

	} // main
} //Class
