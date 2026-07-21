package com.learning;

interface Telusko5
{
	default void course()
	{
		System.out.println("telusko learning");
		ai();
		sd();
	}
	
	static void ai()
	{
		System.out.println("ai static method of interface");
	}
	private void sd()
	{
		System.out.println("system design course");
	}
}

class AI implements Telusko5
{
//	public void course()
//	{
//		System.out.println("telusko learning");
//	}
}
public class LaunchInterface2 
{
	public static void main(String[] args)
	{
		Telusko5 t=new AI();
		t.course();
		//t.ai();
		Telusko5.ai();
	}

}
