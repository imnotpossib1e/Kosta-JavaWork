package ex0803.ch05;

import java.util.Scanner;

class Grade{
	int studentCnt = 0;
	int[] scores;
	
	public void student(int i) {
		this.studentCnt = i;
		this.scores = new int[i];
	}
	
	public void setScore(int num, int score) {
		scores[num] = score;
	}
	
	public void printScore() {
		for(int i = 0; i<studentCnt; i++) {
			System.out.printf("scores[%d]: %d\n", i, scores[i]);
		}
	}
	
	public void analyze() {
		int max = 0;
		int sum = 0;
		for(int i = 0; i<studentCnt; i++) {
			if(max < scores[i]) {
				max = scores[i];
			}
			sum += scores[i];
		}
		
		double avg = (double)(sum/studentCnt);
		
		System.out.println("최고점수: " + max);
		System.out.println("평균점수: " + avg);
	}
}

public class Problem09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Grade grade = new Grade();
		
		outer:
		while(true) {
			System.out.println("------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("------------------------------------------");
			int choice = 0;
			System.out.print("선택 > ");
			choice = Integer.parseInt(sc.nextLine());
			
			
			switch(choice) {
				case 1: {
					System.out.print("학생수 > ");
					grade.student(Integer.parseInt(sc.nextLine()));
					break;
				}
				case 2: {
					int stNum = grade.studentCnt;
					for(int i = 0; i<stNum; i++) {
						System.out.printf("scores[%d] > ", i);
						grade.setScore(i, Integer.parseInt(sc.nextLine()));
					}
					break;
				}
				case 3: {
					grade.printScore();
					break;
				}
				case 4: {
					grade.analyze();
					break;
				}
				case 5:{
					System.out.println("프로그램 종료");
					break outer;
				}
			}
		}

	}

}
