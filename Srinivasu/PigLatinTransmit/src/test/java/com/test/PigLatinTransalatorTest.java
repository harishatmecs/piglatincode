package com.test;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import com.transalator.PigLatinTransalator;

import static org.junit.Assert.assertEquals;

public class PigLatinTransalatorTest {

	private PigLatinTransalator pigLatinTranslator;

	@Before
	public void setup() {
		PigLatinTransalator pigLatinTransalator = new PigLatinTransalator();
	}


	@Test
	public void testWordBeginningWithA() {
		assertEquals("arrayway", pigLatinTranslator.translatedWord("array"));

	}


	@Test
	public void testWordBeginningWithI() {
		assertEquals("i have deployed code in production environment successfullyway", pigLatinTranslator.translatedWord("i have deployed code in production environment successfully"));

	}


	@Test
	public void testWordBeginningWithE() {
		assertEquals("i got bugs in production code", pigLatinTranslator.translatedWord("i got bugs in production code"));

	}

	@Test
	public void testWordBeginningWithH() {
		assertEquals("Ellohay", pigLatinTranslator.translatedWord("Hello"));
	}


	@Test
	public void testWordBeginninWithC() {
		assertEquals("Ode Deployed Successfullycay", pigLatinTranslator.translatedWord("Code deployed successfully"));
	}


	@Test
	public void testWordBeginningWithD() {
		assertEquals("Defects identified", pigLatinTranslator.translatedWord("defects identified"));
	}


	@Test
	public void testWordEndWithway() {
		assertEquals("stairway", pigLatinTranslator.translatedWord("stairway"));
	}


	@Test
	public void testWordWithWay() {
		assertEquals("i am on the way", pigLatinTranslator.translatedWord("i am on the way"));
	}


	@Test
	public void testWordContainWay() {
		assertEquals("Airways", pigLatinTranslator.translatedWord("Airway"));
	}

	@Test
	public void testWordForCapitilastion() {
		assertEquals("Eachbay", pigLatinTranslator.translatedWord("Beach"));
	}


	@Test
	public void testWordCapital() {
		assertEquals("Ccloudmay", pigLatinTranslator.translatedWord("McCloud"));
	}


	@Test
	public void testWordCapitilsation(){
		assertEquals("Running Code", pigLatinTranslator.translatedWord("Running Code"));
	}



}
