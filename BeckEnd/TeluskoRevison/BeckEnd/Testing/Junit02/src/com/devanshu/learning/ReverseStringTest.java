package com.devanshu.learning;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseStringTest {

	@Test
	public void test() {
		ReverseString reverse = new ReverseString();
	String actual = reverse.reverseString("Java");
	String expected = "avaJ";
	assertEquals(expected, actual);
	}

}
