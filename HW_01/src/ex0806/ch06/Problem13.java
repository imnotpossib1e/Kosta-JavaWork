package ex0806.ch06;

/**
 * 13번, 14번 
 */
class Member{
	String name;
	String id;
	String password;
	int age;
	
	public Member() {
		
	}
	
	public Member(String name, String id) {
		this.name = name;
		this.id = id;
	}
}

public class Problem13 {

	public static void main(String[] args) {
		Member user1 = new Member("홍길동", "hong");

	}

}
