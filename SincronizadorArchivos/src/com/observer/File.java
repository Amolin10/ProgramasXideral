package com.observer;

public class File extends Subject {

	void escribir(String texto) {
		System.out.println(texto);
		notificar(texto);
	}
	
}
