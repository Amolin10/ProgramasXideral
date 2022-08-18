package com.luv2code.web.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Implementación de Servlet
 * @author AMolin
 */
/**
 * Nombre del servlet
 * @author Amolin
 */
@WebServlet("/DeportistaControllerServlet")
public class DeportistaControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Tiene una utilería para manejar la base de datos de deportista
	 */
	private DeportistaDbUtil deportistaDbtil;
	
	/**
	 * Inyección del recurso desde Deployed/webapp/META-INF/context.xml
	 * TomCat toma este archivo
	 */
	//@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	/**
	 * Inicializa la utilería
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our deportistas db util ... and pass in the conn pool / datasource
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/javatechie");
			System.out.println("Demo con JNDI, Datasource: "+dataSource);
			deportistaDbtil = new DeportistaDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	/**
	 * Método doGet para escuchar las peticiones que utilizan el método GET
	 * Lee el comando y en base a él ejecuta la funcinalidad
	 * @param request es dada por la petición
	 * @param response es dado por la petición
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing deportistas
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listaDeportistas(request, response);
				break;
				
			case "ADD":
				addDeportista(request, response);
				break;
				
			case "LOAD":
				loadDeportista(request, response);
				break;
				
			case "UPDATE":
				updateDeportista(request, response);
				break;
			
			case "DELETE":
				deleteDeportista(request, response);
				break;
				
			default:
				
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	/**
	 * Utiliza la utilidad para eliminar un deportista de la base de datos
	 * @param request es dada por la petición
	 * @param response es dada por la petición
	 * @throws Exception si no se pude conectar a la base de datos, o no puede ejecutar la sentencia sql
	 */
	private void deleteDeportista(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student id from form data
		String theDeportistaId = request.getParameter("deportistaId");
		
		// delete student from database
		deportistaDbtil.deleteDeportista(theDeportistaId);
		
		// send them back to "list students" page
		listaDeportistas(request, response);
	}
	
	/**
	 * Obtiene un deportista con ayuda de la utilidad y lo coloca en una nuevo jsp para modificar sus valores
	 * @param request es dada por la petición
	 * @param response es dada por la petición
	 * @throws Exception si no se pude conectar a la base de datos, o no puede ejecutar la sentencia sql
	 */
	private void loadDeportista(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		String thDeportistaId = request.getParameter("deportistaId");
		
		// get student from database (db util)
		Deportista theDeportista = deportistaDbtil.getDeportista(thDeportistaId);
		//System.out.println(theDeportista);
		
		// place student in the request attribute
		request.setAttribute("EL_DEPORTISTA", theDeportista);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-deportista-form.jsp");
		dispatcher.forward(request, response);			
	}
	
	/**
	 * Utiliza la utilidad para actualizar los campos de un deportista de la base de datos
	 * @param request es dada por la petición
	 * @param response es dada por la petición
	 * @throws Exception si no se pude conectar a la base de datos, o no puede ejecutar la sentencia sql
	 */
	private void updateDeportista(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student info from form data
		int id = Integer.parseInt(request.getParameter("deportistaId"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String deporte = request.getParameter("deporte");
		
		// create a new student object
		Deportista theDeportista = new Deportista(id, nombre, apellido, deporte);
		
		//System.out.println(theDeportista);
		// perform update on database
		deportistaDbtil.updateDeportista(theDeportista);
		
		// send them back to the "list students" page
		listaDeportistas(request, response);
		
	}
	
	/**
	 * Utiliza la utilidad para insertar un deportista en base de datos
	 * @param request es dada por la petición
	 * @param response es dada por la petición
	 * @throws Exception si no se pude conectar a la base de datos, o no puede ejecutar la sentencia sql
	 */
	private void addDeportista(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read deportista info from form data
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String deporte = request.getParameter("deporte");		
		
		// create a new deportista object
		Deportista theDeportista = new Deportista(nombre, apellido, deporte);
		
		// add the deportista to the database
		deportistaDbtil.addDeportista(theDeportista);
				
		// send back to main page (the deportista list)
		listaDeportistas(request, response);
	}
	
	/**
	 * Utiliza la utilidad para obtener una lista de deportistas y mostrarla en ese jsp
	 * indica el atributo "LISTA_DEPORTISTAS" para que el jsp pueda extraer los datos de la
	 * lista y colocarlos del lado del browser
	 * @param request es dada por la petición
	 * @param response es dada por la petición
	 * @throws Exception si no se pude conectar a la base de datos, o no puede ejecutar la sentencia sql
	 */
	private void listaDeportistas(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

			// get deportista from db util
			List<Deportista> deportistas = deportistaDbtil.getDeportistas();
			for(Deportista dp: deportistas) {
				System.out.println(dp);
			}
			System.out.println("************************************************");
			
			// add students to the request
			request.setAttribute("LISTA_DEPORTISTAS", deportistas);
					
			// send to JSP page (view)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-deportistas.jsp");
			dispatcher.forward(request, response);
		}

}