package edu.wpi.cs3733.entity;

/**
 * Caesar cipher; you must implement the cipher and the observer pattern
 */
public class CaesarCipher implements Observer {
	private String input = "";

	public void setText(String text){
		this.input = text;
	}

	public String getText(){
		if(valid(input)) {
			return convert(input);
		}
		else {
			return "";
		}
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

	private boolean valid(String toConvert) {
		if(toConvert.length() > 140) {
			return false;
		}

		for(char c : toConvert.toCharArray()) {
			if (c != 33 && c != 63 && c != 44 && c != 46 && c != 32 && !(c >= 65 && c <= 90) && !(c >= 97 && c <= 122)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void notify(Object object){
		input = ((Message)object).getText();
	}
}
