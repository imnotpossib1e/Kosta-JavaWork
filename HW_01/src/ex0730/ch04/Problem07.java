package ex0730.ch04;

import java.util.Scanner;

public class Problem07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int bal = 0;
		outer:
		while(true) {
			System.out.println("-------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("-------------------------------------");
			System.out.print("선택> ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1: {
					System.out.print("예금액> ");
					int cash = sc.nextInt();
					bal += cash;
					break;
				}
				case 2: {
					System.out.print("출금액> ");
					int cash = sc.nextInt();
					bal = bal - cash;
					break;
				}
				case 3: {
					System.out.println("잔고> " + bal);
					break;
				}
				default: {
					System.out.println();
					System.out.println("프로그램 종료");
					break outer;
				}
			}
		}
	}
}
