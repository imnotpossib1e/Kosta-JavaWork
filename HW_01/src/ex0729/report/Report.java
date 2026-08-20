package ex0729.report;

public class Report {

	public static void main(String[] args) {
		// 이름 저장 변수 선언
		String name = "이진현";
		
		// 성적 저장 변수 선언
		int korean = (int)(Math.random()*56 + 45);
		int english = (int)(Math.random()*56 + 45);
		int math = (int)(Math.random()*56 + 45);

		// 총점, 평균, 학점 저장 변수 선언
		int sum = korean + english + math;
		
		double avg = sum / 3.0;
		
		// 소수점 두번째 자리까지
		// double avg = (int)(sum / 3.0 * 100) / 100.0;
		
		// if 문
		char creditIf;
		
		if(avg >= 90) {
			creditIf = 'A';
		}else if(avg >= 80) {
			creditIf = 'B';
		}else if(avg >= 70) {
			creditIf = 'C';
		}else if(avg >= 60) {
			creditIf = 'D';
		}else {
			creditIf = 'F';
		}
		
		// switch 문
		int intAvg = (int)(avg/10);
		char creditSwitch;
		
		switch(intAvg) {
			case 10, 9: creditSwitch = 'A'; break;
			case 8: creditSwitch = 'B'; break;
			case 7: creditSwitch = 'C'; break;
			case 6: creditSwitch = 'D'; break;
			default: creditSwitch = 'F';
		}
		
		char creditSwitch2 = switch((int)(avg/10)) {
			case 10, 9 -> 'A';
			case 8 -> 'B';
			case 7 -> 'C';
			case 6 -> 'D';
			default -> 'F';
		};
		
		System.out.println("이름: " + name);
		System.out.println("국어점수: " + korean + " 영어점수: " + english + " 수학점수: " + math);
		System.out.println("총점: " + sum + " 평균: " + avg + " 학점: " + creditIf);
		System.out.println("총점: " + sum + " 평균: " + avg + " 학점: " + creditSwitch);
		System.out.println("총점: " + sum + " 평균: " + avg + " 학점: " + creditSwitch2);
	}

}
