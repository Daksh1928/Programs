class Student {

	int id;
	String name;
	double age;

	void sleep() {
		System.out.println("Student is sleeping ");
	}

	void study() {
		System.out.println("Student must study ");
	}
}

public class LaunchOOP1 {

	public static void main(String[] args) {
		Student stu = new Student();
		stu.age = 19;
		stu.id = 24;
		stu.name = "Daksh";
		stu.sleep();
		stu.study();
	}

}
