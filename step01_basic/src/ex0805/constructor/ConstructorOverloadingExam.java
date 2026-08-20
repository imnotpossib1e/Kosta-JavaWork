package ex0805.constructor;

class Puppy3 {
	/* String 타입 전역 변수 선언
	 * int 타입 전역 변수 선언 */
	private String name;
	private int age;
		
	
	/* 인수가 없는 생성자작성
	 * String 타입 전역변수에 "메리" 할당
	 * "puplic Puppy3()호출되었습니다"출력
	 * 전역변수 출력
	 */		
	public Puppy3() {
		this.name = "메리";
		System.out.println("puplic Puppy3()호출되었습니다");
		System.out.printf("이름: %s  숫자: %d\n", this.name, this.age);
	}
	
	
	/* String 타입의 인수 1개를 받는 생성자작성
	 * String 타입 전역변수에 인수 할당
	 * "puplic Puppy3()호출되었습니다"출력
	 * 전역변수 출력
	 */
	public Puppy3(String s) {
		this.name = s;
		System.out.println("public Puppy3(String s)호출되었습니다");
		System.out.printf("이름: %s  숫자: %d\n", this.name, this.age);
	}
		
	
	/* String 타입의 인수 2개를 받는 생성자작성
	 * 인수2개를 하나의 String으로 만들어
	 * String 타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
	 * "puplic Puppy3()호출되었습니다"출력
	 */
	public Puppy3(String str1, String str2) {
		this(str1 + str2);
		System.out.println("public Puppy3(String str1, String str2)호출되었습니다");
	}

	
	/* boolean 타입의 인수 1개를 받는 생성자작성
	 * 인수를 "쫑"과 붙여 하나의 String으로 만들어
	 * String 타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
	 * "puplic Puppy3()호출되었습니다"  출력
	 */
	public Puppy3(boolean b) {
		this(b+"쫑");
		System.out.println("public Puppy3(boolean b)호출되었습니다");
	}

	
	
	
	/* char 타입의 인수 1개를 받는 생성자작성
	 * 인수가 없는 생성자를 호출하고
	 * 인수로 받은 data를 int타입 전역변수에 할당	
	 * "puplic Puppy3()호출되었습니다"출력
	 * int형 전역변수출력
	 */
	public Puppy3(char c) {
		this();
		this.age = c;
		System.out.println("public Puppy3(char c)호출되었습니다");
		System.out.printf("숫자: %d\n", this.age);
	}
	
	
	/* 메소드 printMemberVariable
	 * 리턴 없슴
	 * 전역변수를 출력
	 */
	public void printMemberVariable() {
		System.out.printf("이름: %s  숫자: %d\n", this.name, this.age);
	}
		

	
}

public class ConstructorOverloadingExam{
		// 메인메소드에서
		public static void main(String [] args){
			// Puppy3 클래스의 각 생성자를 한번씩 이용해 객체 5개 생성
			Puppy3 pp1 = new Puppy3();
			Puppy3 pp2 = new Puppy3("강아지");
			Puppy3 pp3 = new Puppy3("쩡이", "깡이");
			Puppy3 pp4 = new Puppy3(true);
			Puppy3 pp5 = new Puppy3('c');
			
			// 각 객체의 printMemberVariable메소드를 한번씩 호출
			pp1.printMemberVariable();
			pp2.printMemberVariable();
			pp3.printMemberVariable();
			pp4.printMemberVariable();
			pp5.printMemberVariable();
	}
}