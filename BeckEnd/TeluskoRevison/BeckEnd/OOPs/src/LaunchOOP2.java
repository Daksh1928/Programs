class Dog {
	int cost;
	String name;

	void barks() {
		int age = 4;
		cost = 10;
		System.out.println("Dog barks");
		age = 6;
		System.out.println(age + " years old " + cost + "k it costs ");
	}

	void run() {
		System.out.println("Dog runs ");
	}

}

public class LaunchOOP2 {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.barks();
		dog.run();
	}

}
