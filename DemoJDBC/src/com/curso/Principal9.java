package com.curso;

import java.sql.*;

public class Principal9 {

	public static void main(String[] args) throws SQLException {
		try (Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/web_student_tracker?useSSL=false", 
					"webstudent", 
					"webstudent")){ 
			register(conn,15,"Armando","Molina","VolleyBall");		
		}
	}

	public static void register(Connection conn, int id, String nombre, String apellido, String deporte) throws SQLException {
		String sql = 
			"INSERT INTO deportista VALUES(?,?,?,?)"; 
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.setString(2, nombre);
			ps.setString(3, apellido);
			ps.setString(4, deporte);
			ps.executeUpdate();
		}
	}

}
