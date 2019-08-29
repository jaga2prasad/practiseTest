package com.jaga;

public class GS2 {
	public static void main(String[] args) {
		String test = "MNMMM";
		char[] t = test.toCharArray();
		String finalRes = "";
		//firstCheck
		String value = compareVal (t[0],t[1]);
		if(value == "MN") {finalRes = "21";}
		if(value == "NM" || value == "NN") {finalRes = "12";}
		//if value is MM still needs to check for next character
		
		
	}
	
	public static String compareVal(char firstPos , char secondPos){
		if(firstPos == 'M'){
			if(firstPos == secondPos){
				return "MM";
			} else {
				return "MN";
			}
		} else if(firstPos == 'N') {
			if(firstPos == secondPos){
				return "NN";
			} else {
				return "NM";
			}
		}
		return "";
	}
	
}
