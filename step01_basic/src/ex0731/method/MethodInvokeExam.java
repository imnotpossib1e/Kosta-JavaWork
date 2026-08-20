package ex0731.method; 

/**
 * @author 이진현
 * 날짜: 260731
 * 주제: 메소드 3번 예제
 */
class Methodinvoke01{
	// 다음과 같이 메소드를 작성하세요.
	
	/* method 이름 : method01
	 * 어디서나 누구나 접근가능
	 * 정수 리턴
	 * 인수로 정수2개 받음
	 * 인수로 들어온 정수 2개를 곱해서 출력하고 리턴 
	 * */
		
	public int method01(int a, int b) {
		int mul = a * b;
		System.out.println("인수의 곱 : " + mul);
		return mul;
	}
	
}

class Methodinvoke02{
	
	// method 이름 : method02
	// 어디서나 누구나 접근가능,객체를 생성하지 않고도 접근가능
	// 정수 리턴
	// 인수로 정수2개 받음
	
	// 인수로 들어온 정수 2개를 더해서 출력하고 더한수 리턴
		
	public static int method02(int a, int b) {
		int sum = a + b;
		System.out.println("두 인수의 합: " + sum);
		return sum;
	}
	

	
}

public class MethodInvokeExam{
	public static void main(String []args){
		
		// MethodInvoke01의 method01 호출
		Methodinvoke01 miv1 = new Methodinvoke01();
		int re = miv1.method01(1, 2);
		System.out.println("리턴값: " + re);
		

		// MethodInvoke02의 method02 호출
		int re2 = Methodinvoke02.method02(2, 5);
		System.out.println("리턴값: " + re2);
		

	}
}

