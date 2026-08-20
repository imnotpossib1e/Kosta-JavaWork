package ex0730.report;

import java.util.Scanner;

/**
 * @author 이진현
 * 날짜: 
 * 주제:
 */

public class Report {

	public static void main(String[] args) {		
		for(int i = 0; i<5; i++) {
			for(int j = 0; j<=i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("************************");
		
		for(int i = 5; i>0; i--) {
			for(int j = 0; j<i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("************************");
		
		for(int i = 1; i<=5; i++) {
			for(int j = i; j<5; j++) {
				System.out.print(" ");
			}for(int j = 0; j<i; j++ ) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		System.out.println("************************");
		
		for(int i = 5; i>=0; i--) {
			for(int j = 1; j<=5-i; j++) {
				System.out.print(" ");
			}for(int j = 1; j<=i; j++ ) {
				System.out.print("★");
			}
			System.out.println();
		}

	}

}
