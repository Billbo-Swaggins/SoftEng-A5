package edu.wpi.cs3733.entity;

/**
 * Elbonian cipher; you must implement the cipher and the observer pattern
 */
public class ElbonianCipher implements Observer {
	private String input;

	public void setText(String text){

	}

	public String getText(){

		return input;
	}

	@Override
	public void notify(Object object){
		input = ((Message)object).getText();
	}
}
