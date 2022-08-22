package com.client.rest.model;


/**
 * Clase deportista, tiene los mismos atributos que la tabla deportista en la base de datos
 * @author Amolin
 */
public class Deportista {

	// define fields
	private int id;
	private String nombre;
	private String apellido;
	private String deporte;
	
	public Deportista() {
		
	}

	/**
	 * Constructor de la clase
	 * @param nombre
	 * @param apellido
	 * @param deporte
	 */
	public Deportista(String nombre, String apellido, String deporte) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.deporte = deporte;
	}
	
	public Deportista(int id, String nombre, String apellido, String deporte) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.deporte = deporte;
	}

	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	@Override
	public String toString() {
		return "Deportista [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", deporte=" + deporte + "]";
	}
		
}
