package com.observer;

/**
 * File
 * Es un Subject
 * Representa un archivo de texto, el cual es respaldado en la nube por diferentes servicios
 * @author molin
 *
 */
public class File extends Subject {

	/**
	 * Escribir simula la edición del archivo
	 * Al ser modificado se notifica a los observadores (servicios de CloudStorage)
	 * @param texto es lo que el usuario escribe en la línea de comandos (modificación de un archivo)
	 */
	void escribir(String texto) {
		System.out.println(texto);
		notificar(texto);
	}
	
}
