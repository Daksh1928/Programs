package com.learning;

class Demo1 {
	Demo1() {
		System.out.println("Demo1 constructor");
	}

}

class Demo2 extends Demo1 {
	Demo2() {
		super();
		// System.out.println("Demo 2 constructor ");
	}
}

public class LaunchInheritance2 {

	public static void main(String[] args) {
		Demo2 demo = new Demo2();

	}

}

// Constructor can never be inheritated we got output cause of super method
