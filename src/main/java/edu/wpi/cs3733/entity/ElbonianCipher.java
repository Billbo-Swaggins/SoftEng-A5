package edu.wpi.cs3733.entity;

/**
 * Elbonian cipher; you must implement the cipher and the observer pattern
 */
public class ElbonianCipher implements Observer {
	private String input = "";

	public void setText(String text){
		this.input = text;
	}

	public String getText(){
		if(valid(input)) {
			 return convert(input);
		}
		return "";
	}

	private String convert(String toConvert) {
		String toReturn = "";
		int i = 0;

		for(char c : toConvert.toUpperCase().toCharArray()) {
			if (i < 140) {
				if (c >= 65 && c <= 90) {
					int charVal = c - 64;
					toReturn = toReturn + String.format("%02d", charVal);
				}
				else if (c == 48) {
					toReturn = toReturn + "_";

				} else if (c == 32) {
					toReturn = toReturn + "S";
				}
				else if(c >= 49 && c <=57) {
					toReturn = toReturn + ((char) (c + 48));
				}
				else {
					toReturn = toReturn + c;

				}
			}
			i++;
		}
		return toReturn;
	}

	private boolean valid(String toConvert) {
		for(char c : toConvert.toCharArray()) {
			if (!(c >=48 && c <= 57) && c != 33 && c != 63 && c != 44 && c != 46 && c != 32 && !(c >= 65 && c <= 90) && !(c >= 97 && c <= 122)) {
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
