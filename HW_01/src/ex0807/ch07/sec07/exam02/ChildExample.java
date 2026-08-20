package ex0807.ch07.sec07.exam02;

public class ChildExample {

	public static void main(String[] args) {
		Child child = new Child();

		Parent parent = child;

		parent.method1();
		parent.method2();

		// 호출 불가능
		// parent.method3();

	}

}
