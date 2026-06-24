package com.telusko.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShapesTest 
{
	Shapes shape=new Shapes();
	@Test
	void testComputeSquareArea()
	{
		assertNotEquals(5675, shape.computeSquareArea(24));
	}
	
	@Test
	void testComputeSquareArea_WithMessage()
	{
		assertNotEquals(576, shape.computeSquareArea(24), "Message to dev if testcase fail");
	}
	
	
	@Test
	void testComputeSquareArea_Supplier()
	{
		assertNotEquals(556, shape.computeSquareArea(24), ()->"Message to dev if testcase fail");
	}
	

}
