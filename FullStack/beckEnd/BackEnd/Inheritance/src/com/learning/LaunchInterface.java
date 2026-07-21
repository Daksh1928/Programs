package com.learning;

interface Calculator
{
	void sub();
}

//interface Calc implements Calculator illegal
//interface Calc extends Calculator
interface Calc 
{
	float pi=3.14f;  //public final static float pi=:3.14f;
	void add(int a, int b);//public abstect void add(int a, int b);
    int mul(int a, int b);
    //void sub();
}
class MyCalc implements Calc, Calculator
{
	public void add(int a, int b)
	{
		int c=a+b;
		System.out.println("add result is "+c);
	}
	public int mul(int a, int b)
	{
		return a*b;
	}
	
	public void sub() 
	{
		// TODO Auto-generated method stub
		
	}
}
class TeluskoLearning
{
	public void add(int a, int b)
	{
		
	}
}
class MyCalc2 extends TeluskoLearning implements Calc
{
	public void add(int a, int b)
	{
		int c=a+b+100;
		System.out.println("add result is "+c);
	}
	public int mul(int a, int b)
	{
		return a*b*100;
	}
}
public class LaunchInterface
{
	public static void main(String[] args)
	{
//		Calc c=new Calc();
		Calc c1=new MyCalc();
		c1.add(4, 4);
		System.out.println(c1.mul(4, 4));
		System.out.println("**********************");
		Calc c2=new MyCalc2();
		c2.add(4, 4);
		System.out.println(c2.mul(4, 4));
		
	}

}
