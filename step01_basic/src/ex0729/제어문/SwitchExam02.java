package ex0729.제어문;

public class SwitchExam02 {

	public static void main(String[] args) {
		// 1 ~ 12사이 난수 발생해서 변수에 담는다
		int month = (int)(Math.random()*12 + 1);
		
		int day = 0;

		// version 14 이후

		/*
		 * 발생한 난수는 월이라고 생각하고
		 * 그 월에 마지막 일수를 출력한다. 
		 **/
		switch(month) {
			case 2 : day = 28; break;
			case 4, 6, 9, 11: day = 30; break;
			default: day = 31; break;
		}
		System.out.println(month + "월은 " + day + "일까지 있습니다.");
		
		int endDay = switch(month) {
			case 2 -> { yield 28; }
			case 4, 6, 9, 11 -> 30;
			default -> 31;
		};
		
		System.out.println(month + "월은 " + endDay + "일까지 있습니다.");
	
		
		// 위 문제를 if문으로 변경해보세요
		int endDay2;

		if(month == 2) {
			endDay2 = 28;
		} else if(month == 4 || month == 6 || month == 9 || month == 11) {
			endDay2 = 30;
		} else {
			endDay2 = 31;
		}
		
		System.out.println(month + "월은 " + endDay2 + "일까지 있습니다.");
		
	}

}


