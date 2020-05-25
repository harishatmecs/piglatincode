package com.piglatin.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PigLatinServiceTest {

	PigLatinService pigLatinServiceg = new PigLatinService();

	@Test
	void testTranslateInLatin() {
		String input = "this This's Hello hello apple appleway stairway   can't e?nd This-thing hjh-apple's sgs?-apple is ta Ta v T a A";
		String expected = "histay Hissta'y Ellohay ellohay appleway appleway stairway   antca'y endw?ay Histay-hingtay jhhay-appleswa'y gssay?-appleway isway atay Atay vay Tay away Away";
		assertEquals(expected, pigLatinServiceg.translateInLatin(input));
	}


	@Test
	void testModiFyTheWord() {
		String input = "stairway";
		String expected = "stairway";
		assertEquals(expected, pigLatinServiceg.modiFyTheWord(input));
	}

	@Test
	void testModiFyTheWord1() {
		String input = "i's";
		String expected = "iswa'y";
		assertEquals(expected, pigLatinServiceg.modiFyTheWord(input));
	}

	@Test
	void testModiFyTheWord2() {
		String input = "i's";
		String expected = "iswa'y";
		assertEquals(expected, pigLatinServiceg.modiFyTheWord(input));
	}

	@Test
	void testAddSpecialWord() {
		String input = "Hello";
		String expected = "Ellohay";
		assertEquals(expected, pigLatinServiceg.addSpecialWord(input, "ay", 1));
	}

	@Test
	void testAddSpecialWord1() {
		String input = "hello";
		String expected = "ellohay";
		assertEquals(expected, pigLatinServiceg.addSpecialWord(input, "ay", 1));

	}


	@Test
	void testPuctuationContainedModifiedWord() {
		String input = "can't";
		String expected = "antca'y";
		assertEquals(expected, pigLatinServiceg.puctuationContainedModifiedWord(input, "ay", 1));
	}

	@Test
	void testPuctuationContainedModifiedWord1() {
		String input = "eat's";
		String expected = "eatswa'y";
		assertEquals(expected, pigLatinServiceg.puctuationContainedModifiedWord(input, "way", 2));
	}

	@Test
	void testContainsPuctuation() {
		String input = "can't";
		boolean expected = true;
		assertEquals(expected, pigLatinServiceg.isContainsPuctuation(input));
	}

	@Test
	void testCheckConditions() {
		String input = "thing";
		int expected = 1;
		assertEquals(expected, pigLatinServiceg.checkConditions(input));
	}

	@Test
	void testCheckConditions1() {
		String input = "old";
		int expected = 2;
		assertEquals(expected, pigLatinServiceg.checkConditions(input));
	}

	@Test
	void testCheckConditions2() {
		String input = "stairway";
		int expected = 3;
		assertEquals(expected, pigLatinServiceg.checkConditions(input));
	}

	@Test
	void testIsWordContainsHyphen() {
		String input = "this-thing";
		boolean expected = true;
		assertEquals(expected, pigLatinServiceg.isContainsPuctuation(input));
	}

}
