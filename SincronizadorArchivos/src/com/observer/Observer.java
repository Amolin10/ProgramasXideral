package com.observer;

public abstract class Observer {

Subject subject;
	
	public Observer(Subject subject) {
		this.subject = subject;
		this.subject.atach(this);
	}

	abstract void update(String texto);

}
