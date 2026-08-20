package ex0807.superkeyword;

class Parent {
//	Parent() {
//		System.out.println(1);
//	}
//
	Parent(int i) {
		System.out.println(2);
	}

	Parent(String s) {
		System.out.println(3);
	}

}

class Child extends Parent { // Child is a Parent 성립
	Child() {
		this(2);
		System.out.println(4);
	}

	Child(int i) {
		super(i);
		System.out.println(5);
	}

	Child(boolean b) {
		super("하이");
		System.out.println(6);
	}
}

public class SuperConstructor {

	public static void main(String[] args) {
		// 자식 생성자 구현부 첫번째 줄에 super(); 생략되어있다.
//		new Child(); // 1 4
//		new Child(3); // 1 5

		// 만약 부모의 생성자가 한개도 없다면
		// 기본 생성자가 자동으로 삽입되어진다.
		new Child(); // 4
		new Child(10); // 5

		// 부모의 기본생성자는 없고 인수 있는 생성자만 있는 경우
		// 자식 생성자 구현부 첫번째 줄에서 모두 에러 발생
		// 반드시 자식 생성자 구현부 첫번째 줄에서 super()가 아닌 다른 생성자를 인위적으로 호출해야 한다.

		new Child(); // 2 5 4
	}

}
