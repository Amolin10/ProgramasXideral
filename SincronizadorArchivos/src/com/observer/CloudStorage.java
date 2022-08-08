package com.observer;

/**
 * Interface de almacenamiento en la nube
 * @author molin
 *
 */
public interface CloudStorage {

	/**
	 * Método para almacenar una copia local 
	 * @param texto es lo que el usuario añadió y se debe almacenar
	 */
	public void almacenarCopia(String texto);
}
