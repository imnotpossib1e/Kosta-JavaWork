package ex0803.staticex;

class Test {
	int a; // 전역변수, 0
	static int b; // static 전역변수, 0
	
	// non-static 메소드 안에서는 non-static, static, this 모두 가능
	public void aa() {
		System.out.println(a); // 0
		System.out.println(this.a); // 0
		
		System.out.println(b); // 0
		System.out.println(this.b); // 0
		System.out.println(Test.b); // 0
		
		// 메소드 호출 - 모두 호출 가능하다
		this.bb();
		bb();
		
		dd();
		this.dd();
		Test.dd();
		
	}
	
	
	public void bb() {
		
	}
	
	// static 메소드 안에서는 static만 접근 가능, this 사용 불가
	public static void cc() {
		// System.out.println(a); // non-static 변수 접근 불가능
		// System.out.println(this.a); // this 키워드 사용 불가
		
		System.out.println(b); // 0 - static 변수 접근 가능
		// System.out.println(this.b); // this 키워드 사용 불가
		System.out.println(Test.b); // 0
		
		// 메소드 호출 - static만 호출 가능하다
		// this.bb(); // non-static 호출 불가능
		// bb(); // non-static 호출 불가능
				
		dd();
		// this.dd(); // this 키워드 사용 불가
		Test.dd();
	}
	
	
	public static void dd() {
		
	}
	
}

public class StaticVariableExam {
	static String s;
	
	public void test() {
		
	}
	public static void main(String[] argss) {
		System.out.println("*** static 변수 ***");

		System.out.println("s = " + s);

		Test t1 = new Test();
		Test t2 = new Test();
		Test t3 = new Test();
		
		// 각자 주소가 다르게 출력된다.
		System.out.println("t1 = " + t1);
		System.out.println("t2 = " + t2);
		System.out.println("t3 = " + t3);
		
		System.out.println("*** non-static 변수 ***");
		System.out.println("t1.a = " + t1.a); // 0
		System.out.println("t2.a = " + t2.a); // 0
		System.out.println("t3.a = " + t3.a); // 0
		
		// 값 변경
		t2.a = 100;
		System.out.println("*** non-static 변수 (값 변경 후) ***");
		System.out.println("t1.a = " + t1.a); // 0
		System.out.println("t2.a = " + t2.a); // 100
		System.out.println("t3.a = " + t3.a); // 0
		
		System.out.println("*** static 변수 ***");
		System.out.println("t1.b = " + t1.b); // 0
		System.out.println("t2.b = " + t2.b); // 0
		System.out.println("t3.b = " + t3.b); // 0
		System.out.println("Test.b = " + Test.b); // 0
		
		// 값 변경
		// t2.b = 50;
		Test.b = 50; // 권장하는 방식
		System.out.println("*** static 변수 (값 변경 후) ***");
		System.out.println("t1.b = " + t1.b); // 50
		System.out.println("t2.b = " + t2.b); // 50
		System.out.println("t3.b = " + t3.b); // 50
		System.out.println("Test.b = " + Test.b); // 50
	}

	/**
	 * 프로젝트가 배포될 때 메인메소드보다 먼저 실행되는 영역
	 * 주로 DB연결, 네트워크 점검, 초기데이터 로딩 등
	 * 프로젝트 전반에 해당하는 configuration 세팅하는 과정
	 */
	static {
		System.out.println("메인 메소드보다 먼저 실행된다.");
	}
}
