package com.devanshu.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseStringTest {

	@Test
	void test() {
		ReverseString reverse = new ReverseString();
	   
		
		assertEquals("avaJ",reverse.reverseString("Java"));
	}
    @Test
	void testReverseString_Multiple() {
		ReverseString reverse = new ReverseString();
		
		assertEquals("ysae si avaJ", reverse.reverseString("Java is easy"));
	}
	
}