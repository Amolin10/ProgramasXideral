package com.observer;

/**
 * Clase Abstracta Observer
 * Recibe un Subject y se adjunta a su lista de observadores para recibir notificaciones
 * @author MRugerio
 */
public abstract class Observer {
	
	/**
	 * Tiene un Subject
	 */
	Subject subject;
	
	/**
	 * Constructor
	 * @param subject para colocarse en su lista de observadores y recibir notificaciones
	 */
	public Observer(Subject subject) {
		this.subject = subject;
		this.subject.atach(this);
	}

	/**
	 * Al recibir notificaciones, actualizar
	 * @param texto es la actualización (modificación) recibida
	 */
	abstract void update(String texto);

}
