package com.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
		List<Observer> listaObservers = new ArrayList<>();
		
		void atach(Observer o) {
			listaObservers.add(o);
		}
		
		void detach(Observer o) {
			listaObservers.remove(o);
		}
		
		void notificar(String texto) {
			for (Observer o:listaObservers) {
				o.update(texto);
			}
		}

}
