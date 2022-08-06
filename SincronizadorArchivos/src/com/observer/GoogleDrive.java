package com.observer;

public class GoogleDrive extends Observer implements CloudStorage {

	StringBuilder sb = new StringBuilder();
	
	public GoogleDrive(Subject subject) {
		super(subject);
	}
	
	@Override
	void update(String texto) {
		almacenarCopia(texto);
	}

	@Override
	public void almacenarCopia(String texto) {
		sb.append(texto + " ");
		System.out.println("---> Contenido Google Drive: " + sb + " ");
	}

}
