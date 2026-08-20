package ex0806.constructor;

/**
 * 싱글톤 클래스 작성
 * 1. private 생성자 만든다
 * 2. 객체를 static 멤버 필드로 선언한다.
 * 3. 객체를 직접 생성해서 반환해주는 메소드를 작성한다
 */
class Test{
	// 외부에서 접근 못하지만 같은 클래스 내에서 접근할 수 있도록
	// getInstance를 여러번 호출해도 하나로 사용할 수 있도록
	private static Test t = new Test();

	// 외부에서 접근 불가 -> 외부에서 객체 생성 불가능
	private Test(){}
	
	// 각 객체의 주소가 다르다.
	/*
	public static Test getInstance(){
		Test instance = new Test();
		return instance;
	}
	*/
	
	
	// 각 객체의 주소 동일
	// 현재 객체를 직접 생성해서 제공해주는 메소드 작성 (외부에서 접근 가능한 메소드 - public static)
	public static Test getInstance(){
		return t;
	}
}

public class PrivateConstructor {

	public static void main(String[] args) {
		// new Test(); // error -> private 생성자이므로 외부에서 객체 생성 불가능

		// 각 객체의 주소는 동일하다
		Test t1 = Test.getInstance();
		Test t2 = Test.getInstance();
		
		System.out.println("t1 = " + t1);
		System.out.println("t1 = " + t2);

	}

}
