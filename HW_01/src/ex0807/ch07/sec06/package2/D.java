package ex0807.ch07.sec06.package2;

import ex0807.ch07.sec06.package1.A;

public class D extends A {

	// 상속을 통해서만 protected 메소드 사용 가능
	public D() {
		// A() 생성자 호출
		super();
	}

	public void method() {
		this.field = "value";
		this.method();
	}

	// 직접 객체 생성해서 사용은 불가능
	public void method2() {
//		A a = new A();
//		a.feild = "value";
//		a.method();
	}
}
