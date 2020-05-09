package edu.wpi.cs3733.entity;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * Message class to hold clear text; you must implement the rest of the class
 */
public class Message implements Observable {
	private String text;
	private ArrayList<Observer> observers = new ArrayList<>();

	public void setText(String text){
		this.text = text;
		notifyObservers();
	}

	public String getText(){
		return text;
	}

	@Override
	public void register(Observer o){
		observers.add(o);
	}

	@Override
	public void notifyObservers(){
		for(Observer o : observers) {
			o.notify(this);
		}
	}
}
