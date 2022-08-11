package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class DeportistaDbUtil {

	private DataSource dataSource;

	public DeportistaDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Deportista> getDeportistas() throws Exception {
		
		List<Deportista> deportistas = new ArrayList<>();
		
		try (	Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery("select * from deportista");
			){
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String deporte = myRs.getString("deporte");
				
				// create new student object
				Deportista tempDeportista = new Deportista(id, nombre, apellido, deporte);
				
				// add it to the list of students
				deportistas.add(tempDeportista);				
			}
			
			return deportistas;		
		}	
	}

	public void addDeportista(Deportista theDeportista) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into deportista "
					   + "(nombre, apellido, deporte) "
					   + "values (?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the deportista
			myStmt.setString(1, theDeportista.getNombre());
			myStmt.setString(2, theDeportista.getApellido());
			myStmt.setString(3, theDeportista.getDeporte());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
		
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
}

