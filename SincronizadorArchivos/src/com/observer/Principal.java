package com.observer;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		File file = new File();
		new GoogleDrive(file);
		new MicrosoftOneDrive(file);
		new DropBox(file);

		Scanner entradaTeclado = new Scanner(System.in);

		while (true) {
			System.out.println("Ingresa una línea de texto");
			String lineaEntrada = entradaTeclado.nextLine();
			if (lineaEntrada.equals("exit")) {
				entradaTeclado.close();
				System.out.println("Termina el programa");
				return;
			}
			file.escribir(lineaEntrada);
		}
	}

}
