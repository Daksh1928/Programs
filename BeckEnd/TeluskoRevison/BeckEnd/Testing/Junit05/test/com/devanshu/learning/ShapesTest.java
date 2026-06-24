package com.devanshu.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShapesTest {

	Shapes shape = new Shapes();

	@Test
	void testcomputeSquareArea() {

		assertEquals(576, shape.computeSquareArea(24));
	}

	@Test
	void testcomputeCircleArea() {

		assertEquals(76.5, shape.computeCircleArea());
		;
	}

	@Test
	void testcomputeCircleArea_Supplier() {
		assertEquals(76.5, shape.computeCircleArea(), () -> "Area of circle is wrong ");
	}
}
