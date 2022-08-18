package com.curso;

import java.sql.*;

public class Principal8 {
	public static void main(String[] args) throws SQLException {
		
		try (
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/web_student_tracker?useSSL=false", 
				"webstudent",
				"webstudent");) { //try
			
			register(conn);
		} //try
						
	} // main
	
	public static void register(Connection conn) throws SQLException {
		String sql = "INSERT INTO deportista VALUES(24, 'Paco', 'Gomez', 'Box')";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.executeUpdate();
		}
		
	}
} //Class
