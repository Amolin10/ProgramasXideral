package com.luv2code.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestWithResources")
public class ServletWithResources extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Define datasource/connection pool for Resource Injection
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Step 1:  Set up the printwriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		// Step 2:  Get a connection to the database
			
		//Try with resources -> cierra recursos automáticamente al terminar el bloque
		try (	Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery("select * from deportista");){
			
			while (myRs.next()) {
				String nombreDeportista = myRs.getString(2);  //Columnas-> 1:id, 2:nombre, 3:apellido, 4:deporte 
				String apellidoDeportista = myRs.getString("apellido");
				String deporte = myRs.getString("deporte");
				out.println(nombreDeportista + " " + apellidoDeportista + ": " + deporte);
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
