package com.curso;

import java.sql.*;

public class Principal2 {
	public static void main(String[] args) throws SQLException {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/web_student_tracker?useSSL=false", 
				"webstudent",
				"webstudent");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM deportista");
			ResultSet rs = ps.executeQuery(); //Es un Map, tiene clave valor					
			) {	
				while (rs.next()) {
					 System.out.print(rs.getInt("id") + " ");
					 System.out.print(rs.getString("nombre") + " ");
					 System.out.print(rs.getString("apellido") + " ");
					 System.out.print(rs.getString("apellido") + " ");
					 System.out.print(rs.getString("deporte") + " ");
					 System.out.println();
				}
			} //try
			
	} // main
} //Class
