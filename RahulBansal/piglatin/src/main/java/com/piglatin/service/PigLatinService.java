package com.piglatin.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class PigLatinService {
	/**
	 * This method takes input as string/sentence and returns output piglatin by calling sub-methods
	 * 
	 * @param sentence
	 * @return
	 */
	public String translateInLatin(String sentence) {
		validate(sentence);
		// Split the sentence/paragraph from space.
		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (StringUtils.isEmpty(word) || "".equals(word.trim()))
				continue;
			String modifiedString = "";
			if (isWordContainsHyphen(word)) {
				String[] hyphenSpilletedWords = word.split("-");
				for (int j = 0; j < hyphenSpilletedWords.length; j++) {
					if (j == hyphenSpilletedWords.length - 1)
						modifiedString += modiFyTheWord(hyphenSpilletedWords[j]);
					else
						modifiedString += modiFyTheWord(hyphenSpilletedWords[j]) + "-";
				}
			} else
				modifiedString = modiFyTheWord(word);
			words[i] = modifiedString;
		}
		//return words.toString();
		return getFinalStringFromWords(words);
	}
/**
 * This method is responsible to convert array string to string after adding space between the words
 * 
 * @param words
 * @return
 */
	public String getFinalStringFromWords(String[] words) {
		String finalString = "";
		for (int i = 0; i < words.length; i++) {
			if (i == words.length - 1)
				finalString += words[i];
			else
				finalString += words[i] + " ";
		}
		return finalString;
	}

	/**
	 * This method is used to modify the word after check all given conditions.
	 * 
	 * @param word
	 * @return it's return final modified pig latin.
	 */
	public String modiFyTheWord(String word) {
		switch (checkConditions(word)) {
		case 1: {
			if (isContainsPuctuation(word))
				return puctuationContainedModifiedWord(word, "ay", 1);
			else
				return addSpecialWord(word, "ay", 1);
		}
		case 2: {
			if (isContainsPuctuation(word))
				return puctuationContainedModifiedWord(word, "way", 2);
			else
				return addSpecialWord(word, "way", 2);
		}
		case 3: {
			return word;
		}

		default:
			return word;
		}
	}

	/**
	 * This method is using for to add special word based on condition like after
	 * checking that word start with vowel or consonant.
	 * 
	 * @param word
	 * @param specialWord
	 * @param rule
	 * @return returning with adding special word based on condition
	 */
	public String addSpecialWord(String word, String specialWord, int rule) {
		if(word.length()==1)
			return word+specialWord;
		if (rule == 1) {
			if (Character.isUpperCase(word.charAt(0)))
				word = word.substring(1, 2).toUpperCase() + word.substring(2) + word.substring(0, 1).toLowerCase()
						+ specialWord;
			else
				word = word.substring(1, 2) + word.substring(2) + word.substring(0, 1) + specialWord;
		} else
			word += specialWord;
		return word;
	}

	/**
	 * This method is using for punctuation contained word to add special word based
	 * on condition like after checking that word start with vowel or consonant.
	 * 
	 * @param word
	 * @param specialWord
	 * @param rule
	 * @return returning with adding special word based on condition
	 */
	public String puctuationContainedModifiedWord(String word, String specialWord, int rule) {
		String temp = "";
		int punctuationPosition = 0;
		char punctuationChar = ' ';
		char firstChar = word.charAt(0);
		for (int k = 0; k < word.length(); k++) {
			if (word.charAt(k) >= 33 && word.charAt(k) <= 63) {
				punctuationPosition = k;
				punctuationChar = word.charAt(k);
			} else
				temp = temp + word.charAt(k);
		}
		if (rule == 1) {
			if (Character.isUpperCase(firstChar))
				temp = temp.substring(1, 2).toUpperCase() + temp.substring(2) + temp.substring(0, 1).toLowerCase()
						+ specialWord;
			else
				temp = temp.substring(1, 2) + temp.substring(2) + temp.substring(0, 1) + specialWord;
		} else
			temp += specialWord;
		StringBuilder finalString = new StringBuilder(temp);
		finalString.insert((temp.length() - (word.length() - 1 - punctuationPosition)), punctuationChar);
		return finalString.toString();
	}

	/**
	 * Will check that word may or may not contains punctuation char.
	 * 
	 * @param word
	 * @return
	 */
	public boolean isContainsPuctuation(String word) {
		for (int k = 0; k < word.length(); k++) {
			if (word.charAt(k) >= 33 && word.charAt(k) <= 63)
				return true;
		}
		return false;
	}

	/**
	 * Checking word start with vowel or consonant.
	 * 
	 * @param word
	 * @return
	 */
	public int checkConditions(String word) {
		char c = word.charAt(0);
		if (word.length() >= 3 && "way".equalsIgnoreCase(word.substring(word.length() - 3)))
			return 3;
		else if ('a' == c || 'A' == c || 'e' == c || 'E' == c || 'i' == c || 'I' == c || 'o' == c || 'O' == c
				|| 'u' == c || 'U' == c)
			return 2;
		else
			return 1;
	}

	/**
	 * Checking that word contains hyphen or not.
	 * 
	 * @param word
	 * @return
	 */
	public boolean isWordContainsHyphen(String word) {
		return word.contains("-");
	}

	/**
	 * Validating the string
	 * 
	 * @param sentence
	 * @throws NullPointerException
	 */
	public void validate(String sentence) throws NullPointerException {
		if (StringUtils.isEmpty(sentence) || "".equals(sentence.trim()))
			throw new NullPointerException("Invalid string !!");
	}

}
