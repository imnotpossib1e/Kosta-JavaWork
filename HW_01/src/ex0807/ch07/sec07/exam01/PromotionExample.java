package ex0807.ch07.sec07.exam01;

class A {

}

class B extends A {

}

class C extends A {

}

class D extends B {

}

class E extends C {

}

public class PromotionExample {

	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();

		// A를 상속받았기 때문에 자동 타입 변화
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;

		// d와 e가 각각 B와 C를 상속받았기 때문에 자동 타입 변화
		B b1 = d;
		C c1 = e;

		// 상속관계에 있지 않으므로 컴파일 에러
//		B b3 = e;
//		C c2 = d;
	}

}
