package com.curso;

import java.sql.*;

public class Principal4 {
	public static void main(String[] args) throws SQLException {
		
		String insertSql = "INSERT INTO deportista VALUES(19, 'Paco', 'Gomez', 'Atletismo con obtaculos')";
		String updateSql = "UPDATE deportista SET nombre = 'Pedro' " + "WHERE nombre = 'Paco'";
		String deleteSql = "DELETE FROM deportista WHERE id = 10";
		
		try (
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/web_student_tracker?useSSL=false", 
				"webstudent",
				"webstudent");
			PreparedStatement ps = conn.prepareStatement(insertSql);
		) { //try
			int result = ps.executeUpdate();
			System.out.println(result);
		}
						
	} // main
} //Class
