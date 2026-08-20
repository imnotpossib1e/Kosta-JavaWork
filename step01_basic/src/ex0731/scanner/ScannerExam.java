package ex0731.scanner;

import java.util.Scanner;

public class ScannerExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어>");
		int kor = sc.nextInt(); // \n 개행문자 무시한다
		
		System.out.print("영어>");
		int eng = sc.nextInt(); // \n 개행문자 무시한다
		
		System.out.print("이름?");
		// String name = sc.next(); // \n 개행문자 무시한다
		sc.nextLine(); // 버퍼에 남은 개행 문자 제거
		String name = sc.nextLine();
		
		System.out.println(name + " 님  " + "kor : " +kor + "\teng : " + eng);
		
		
	}

}
