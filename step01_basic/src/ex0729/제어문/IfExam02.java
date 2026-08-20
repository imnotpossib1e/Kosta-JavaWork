package ex0729.제어문;

public class IfExam02 {

	public static void main(String[] args) {
		// 1~ 12사이 난수 발생 해서 변수에 담는다.
		int num = (int)(Math.random()*12 + 1);
		
		// 발생한 난수가 1이면 일요일, 2이면 월요일, 3이면 화요일, 4이면 수요일
		// 5이면 목요일 6이면 금요일, 이외의 수는 토요일 출력한다.
		if (num == 1) {
			System.out.println("일요일");
		} else if (num == 2) {
			System.out.println("월요일");
		} else if (num == 3) {
			System.out.println("화요일");
		} else if (num == 4) {
			System.out.println("수요일");
		} else if (num == 5) {
			System.out.println("목요일");
		} else if (num == 6) {
			System.out.println("금요일");
		} else {
			System.out.println("토요일");
		}
		
		// 실행문 문장이 하나일 경우 중괄호 생략 가능
		String day = "토";
		if (num == 1) day = "일";
		else if (num == 2) day = "월";
		else if (num == 3) day = "화";
		else if (num == 4) day = "수";
		else if (num == 5) day = "목";
		else if (num == 6) day = "금";
		else day = "토";
		
		System.out.println(num + "은 " + day +  "요일");
	}
}
