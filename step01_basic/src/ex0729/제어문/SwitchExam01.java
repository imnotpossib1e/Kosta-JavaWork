package ex0729.제어문;

public class SwitchExam01 {

	public static void main(String[] args) {
		// 1~ 12사이 난수 발생 해서 변수에 담는다.
		int num = (int)(Math.random()*12 + 1);
	
		String day = "토";
		
		// 발생한 난수가 1이면 일요일, 2이면 월요일, 3이면 화요일, 4이면 수요일
		// 5이면 목요일 6이면 금요일, 이외의 수는 토요일 출력한다.
		switch(num) {
		case 1 : day = "일"; break;
		case 2 : day = "월"; break;
		case 3 : day = "화"; break;
		case 4 : day = "수"; break;
		case 5 : day = "목"; break;
		case 6 : day = "금"; break;
		default: day = "토";
	}
	System.out.println(num + "은 " + day +  "요일");
	}

}
