package com.oops;

import java.util.Scanner;

class Farmer {
	private float amount;
	private float si;
	private float tenure;
	private static float roi;

	static {
		roi = 4.5f;
	}

	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Kindly enter load amount required");
		amount = sc.nextFloat();

		System.out.println("Kindly enter time needed");
		tenure = sc.nextFloat();

	}

	void compute() {
		si = (amount * roi * tenure) / 100.0f;

	}

	void display() {
		System.out.println("SI is : " + si);
	}
}

public class LaunchStatic2 {

	public static void main(String[] args) {
		System.out.println("Farmer Loan Application");
		Farmer f1 = new Farmer();
		System.out.println("Kindly enter details for first farmer");
		f1.input();
		f1.compute();
		f1.display();

		Farmer f2 = new Farmer();
		System.out.println("Kindly enter details for second farmer");
		f2.input();
		f2.compute();
		f2.display();

		Farmer f3 = new Farmer();
		System.out.println("Kindly enter details for third farmer");
		f3.input();
		f3.compute();
		f3.display();

	}

}