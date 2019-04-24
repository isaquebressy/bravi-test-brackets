package br.com.bressy.isaque.brackets.main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.bressy.isaque.brackets.main.BracketsMain;

class BracketsMainTest {

	@Test
	void testValidMatch() {
		assertTrue(BracketsMain.match("[{()}](){}"));
	}
	
	@Test
	void testInvalidMatch() {
		assertFalse(BracketsMain.match("[{)]"));
	}

	@Test
	void testInvalidCharacters() {
		assertFalse(BracketsMain.match("[aaa]"));
	}
	
	@Test
	void testInvalidOrder() {
		assertFalse(BracketsMain.match("][()"));
	}
}
