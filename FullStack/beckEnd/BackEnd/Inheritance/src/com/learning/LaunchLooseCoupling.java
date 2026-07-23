package com.learning;

class A{
	 void disp(){
		System.out.println("A");
	 }
}

class B {
	void show(){
		A a = new A();
		a.disp();
	}
}

public class LaunchLooseCoupling {

	public static void main(String[] args) {
		A a = new A();
		a.disp();
		B b = new B();
		b.show();

	}

}
