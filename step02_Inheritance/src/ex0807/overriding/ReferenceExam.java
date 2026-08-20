package ex0807.overriding;

class ObjectExam {
	String str;

	public ObjectExam() {
	}

	// overloading
	public ObjectExam(String str) {
		this.str = str;
	}

	public String toString() {
//		return "집에가고싶다";
//		return str; // 집에가요 안녕
		return super.toString() + str; // 주소+집에가요
	}

}

class ReferenceExam {
	public static void main(String[] args) {
		char c = 'a';
		String s01 = "장희정";
		String s02 = "Java";
		String s03 = new String("월요일");
		ObjectExam oe1 = new ObjectExam("집에가요");
		ObjectExam oe2 = new ObjectExam("안녕");

		// System.out.println(객체) or System.out.println(객체
		// 인수 객체가 오면 객체.toString() 호출됨

		System.out.println(c); // a
		System.out.println(s01.toString()); // 장희정
		System.out.println(s02); // Java
		System.out.println(s03); // 월요일
		System.out.println(oe1); // 집에가고싶다.
		System.out.println(oe2); // oe2 주소(toString 오버라이드 안 한 경우)

	}
}
