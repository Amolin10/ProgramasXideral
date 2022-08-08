package com.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Subject
 * @author MRugerio
 *
 */
public class Subject {
	/**
	 * Tiene uno o varios observadores
	 */
	List<Observer> listaObservers = new ArrayList<>();
	
	/**
	 * Adjuntar observador a la lista
	 * @param o es el observador a añadir
	 */
	void atach(Observer o) {
		listaObservers.add(o);
	}
	
	/**
	 * Eliminar observador de la lista
	 * @param o es el observador a eliminar
	 */
	void detach(Observer o) {
		listaObservers.remove(o);
	}
	
	/**
	 * Notificar a los observadores de un cambio o acción, ejecuta para cada observador el método update()
	 * @param texto es el cambio que se indica a los observadores.
	 */
	void notificar(String texto) {
		for (Observer o:listaObservers) {
			o.update(texto);
		}
	}

}
