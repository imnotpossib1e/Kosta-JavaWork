package ex0806.enumex;

public class EnumTest {

	public static void main(String[] args) {
		// enum 사용
		Grade grade = Grade.BASIC;
		
		// enum 사용시 switch문 사용하는 것이 더 깔끔하다
		switch(grade) {
		case BASIC: 
			System.out.println("일반고객"); break;
		case SILVER:
			System.out.println("우수고객"); break;
		case GOLD:
			System.out.println("최우수고객");
		}
		
		System.out.println(grade.getKind());
		System.out.println(grade.getPoint());
		System.out.println(grade.getRole());
		
		
	}
}
