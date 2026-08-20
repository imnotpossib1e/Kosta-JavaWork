package ex0807.ch07.sec07.exam03;

public class ChildExample {

	public static void main(String[] args) {
		Parent parent = new Child();

		parent.field1 = "data1";
		parent.method1();
		parent.method2();

		// 부모가 자식의 필드와 페소드에 접근 불가
		/*
		 * parent.field2 = "data2"; parent.method3();
		 */

		// 타입 변환
		Child child = (Child) parent;

		child.field2 = "data2";
		child.method3();
	}

}
