package edu.wpi.cs3733.entity;

/**
 * Caesar cipher; you must implement the cipher and the observer pattern
 */
public class CaesarCipher implements Observer {
	private String input;

	public void setText(String text){

	}

	public String getText(){
		return convert(input);
	}

	private String convert(String toConvert) {
		String toReturn = "";
		for(char c : toConvert.toCharArray()) {
			int i = (int) c;
			if(i >= 65 && i <= 90) {
				i = 90 - i + 65;
			}
			else if(i >= 97 && i <= 122) {
				i = 122 - i + 97;
			}
			c = (char) i;
			toReturn = toReturn + c;
		}
		return toReturn;
	}

	@Override
	public void notify(Object object){
		input = ((Message)object).getText();
	}
}
