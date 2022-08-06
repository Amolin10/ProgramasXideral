package com.observer;

public class MicrosoftOneDrive extends Observer implements CloudStorage {

	StringBuilder sb = new StringBuilder();
	
	public MicrosoftOneDrive(Subject subject) {
		super(subject);
	}

	@Override
	void update(String texto) {
		almacenarCopia(texto);
	}

	@Override
	public void almacenarCopia(String texto) {
		sb.append(texto + " ");
		System.out.println("---> Contenido Microsoft OneDrive: " + sb);
	}
	
}
