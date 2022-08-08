package com.observer;

/**
 * MicrosoftOneDrive
 * Es un Observador
 * Es un CloudStorage
 * @author molin
 *
 */
public class MicrosoftOneDrive extends Observer implements CloudStorage {

	/**
	 * Variable para almacenar las líneas de texto que añade el usuario
	 */
	StringBuilder sb = new StringBuilder();
	
	/**
	 * Constructor heredado de Observer
	 * @param subject es el elemento que escuchará a la espera de una notificación
	 */
	public MicrosoftOneDrive(Subject subject) {
		super(subject);
	}

	/**
	 * LLamar al método local almacenarCopia
	 * @param texto el la línea de texto que añadió el usuario
	 */
	@Override
	void update(String texto) {
		almacenarCopia(texto);
	}

	/**
	 * Añadir al StringBuilder sb la cadena escrita por el usuario
	 * Mostrar todo el contenido del StringBuilder
	 * @param texto el la línea de texto que añadió el usuario
	 */
	@Override
	public void almacenarCopia(String texto) {
		sb.append(texto + " ");
		System.out.println("---> Contenido Microsoft OneDrive: " + sb);
	}
	
}
