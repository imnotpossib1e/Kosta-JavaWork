package ex0729.제어문;

public class IfExam01 {

	public static void main(String[] args) {
		// 1. 정수형 변수를 선언하고 적당히 초기화한다.
		// 난수발생
		int num = (int)(Math.random()*56 + 45);
		
		// 2. 선언한 정수의 값이 짝수이면 짝수입니다. 아니면 홀수입니다. 출력
		if(num % 2 == 0) {
			System.out.println(num + " 은 짝수입니다.");
		} else {
			System.out.println(num + " 은 홀수입니다.");
		}
		
		// 7의 배수인지 판별
		if(num % 7 == 0) {
			System.out.println(num + " 은 7의 배수입니다.");
		}else {
			System.out.println(num + " 은 7의 배수가 아닙니다.");
		}
		
		
	}

}
