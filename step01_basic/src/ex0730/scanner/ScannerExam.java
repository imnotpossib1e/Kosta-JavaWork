package ex0730.scanner;

import java.util.Scanner;

public class ScannerExam {

	public static void main(String[] args) {
		// 키보드 입력받기
		// 자동 import 단축어: ctrl + shift + o 
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. 성적표 \t 2. 종료");
			System.out.print("선택 > ");
			int choice = sc.nextInt();
			
			if(choice==1) {
				System.out.print("이름 입력: ");
				String name = sc.next();
					
				System.out.print("국어 점수 입력: ");
				int kor = sc.nextInt();
						
				System.out.print("영어 점수 입력: ");
				int eng = sc.nextInt();

				System.out.println("이름: " + name);
				System.out.println("국어점수: " + kor);
				System.out.println("영어점수: " + eng);
				System.out.println("총합: " + (kor+eng));
			}else if(choice==2)break;
			else System.out.println("다시 입력해주세요.");
			
		}
	}

}
