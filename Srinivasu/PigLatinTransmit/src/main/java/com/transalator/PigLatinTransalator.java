package com.transalator;



import java.util.Scanner;

public class PigLatinTransalator {

	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Enter word that you would like to translate ");
		String inputString = scan.nextLine();
		String output = "";
		// Translates word individually
		String TestWord = translatedWord(inputString); 
		// Joins translated word back to the output
		output += TestWord + " "; 
		System.out.println("Original Word: " + inputString);
		System.out.println("Translation: " + output + "\n");
	}

	public static String translatedWord(String str) {
		String lowerCaseWord = str.toLowerCase();
		// first vowel position
		int position = -1;
		char ch;
		// first vowel index in the word
		for (int i = 0; i < lowerCaseWord.length(); i++) {
			ch = lowerCaseWord.charAt(i);
			if (isVowel(ch)) {
				position = i;
				break;

			}
		}
		if(position > 1)
		{
			position = 1;
		}
		// word that ends in way are not modified
		if(str.endsWith("way")) {
			return str;
		}

		if (position == 0) {
			// if first character is vowel transalate the word
			// Add "way" to the end of string
			return str+"way"; 
		} else {


			String a = lowerCaseWord.substring(position); 
			String b = lowerCaseWord.substring(0, position); 
			//  Adding "ay" at the end of the extracted words after appending
			String c = a+b+"ay";
			//capitilazation must remain in the same place
			String words[]=c.split("\\s");  
			String capitalizeWord="";  
			for(String w:words){  
				String first=w.substring(0,1); 
				String afterfirst=w.substring(1);
				capitalizeWord+=first.toUpperCase()+afterfirst+" ";
			}  
			return capitalizeWord.trim();
		}
	}

	// This method checks if the character  is a vowel
	public static Boolean isVowel(char ch) {
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' |ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'  ){
			return true;
		}
		return false;
	}
}
