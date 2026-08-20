package ex0731.report;

import java.util.Scanner;

/**
 * @author 이진현
 * 날짜: 260731
 * 주제: 성적표 구하기 ver.2
 */
class Grade{
	
	// 총점 - private
	/**
	 * 
	 * @param kor
	 * @param eng
	 * @param math
	 * @return : 국어, 영어, 수학을 더한 결과 리턴
	 */
	private int total(int kor, int eng, int math) {
		int sum = kor + eng + math;
		return sum;
	}
	
	// 총점, 과목수 받아 평균 - private
	private double avg(int sum, int sub) {
		double re = sum / sub;
		return re;
	}
	
	// 평균 받아 등급 - private
	private char grade(double avg) {
		char result = switch((int)(avg/10)) {
			case 10, 9 -> 'A';
			case 8 -> 'B';
			case 7 -> 'C';
			case 6 -> 'D';
			default -> 'F';
		};
		return result;
	}
	
	// 점수 받아 총점, 평균, 등급 출력
	public void gradePrint(String name, int kor, int eng, int math) {
		int total = this.total(kor, eng, math);
		double avg = this.avg(total, 3);
		char grade = this.grade(avg);
		
		System.out.println("이름: " + name);
		System.out.print("총점: " + total	);
		System.out.print("\t평균: " + avg);
		System.out.println("\t등급: " + grade);
		System.out.println();
		
	}
	
}

public class ReportCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Grade grade = new Grade(); // 객체 생성은 반복문 밖에서
		

		while(true){
			System.out.println("1. 성적표 구하기 \t 2. 종료");
			System.out.print("선택 > ");

			
			int choice = Integer.parseInt(sc.nextLine());
			if(choice == 1) {
				System.out.print("이름: ");
				String name = sc.nextLine();
				
				System.out.print("국어 점수: ");
				int kor = Integer.parseInt(sc.nextLine());
				
				System.out.print("영어 점수: ");
				int eng = Integer.parseInt(sc.nextLine());
				
				System.out.print("수학 점수: ");
				int math = Integer.parseInt(sc.nextLine());
				System.out.println();
				
				grade.gradePrint(name, kor, eng, math);
				
			}else {
				System.out.println("종료");
				break;
			}
		}
		
		
	}

}
