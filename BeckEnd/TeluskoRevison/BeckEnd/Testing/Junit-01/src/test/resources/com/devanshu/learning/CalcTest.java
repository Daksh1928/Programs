package com.devanshu.learning;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcTest {

	@Test
	public void test() {
		Calc c = new Calc();
		c.divide(50,5);
		int expectedResult = 10;
		
		assertEquals(expectedResult ,actual);
	}

}
