package ex0803.overloading;

import java.util.Calendar;
import java.util.GregorianCalendar;

class  PrintfExam{
	public static void main(String[] args) {
		System.out.printf("%d%d%n",20,30);
		System.out.printf("%d , %d%n",20,30);
		System.out.println();
		
		// 가격 콤마 표시
		System.out.printf("가격 : %,d원%n",25320000);
		
		// 전체 5자리에 소수점 2자리까지 표시
		System.out.printf("%5.2f%n",35.33333);
		
		System.out.println();
		System.out.printf("%d년  %d월 %d일%n",2009,5,3);
		
		// 출력 순서 지정
		System.out.printf("%2$d년 %3$d월 %1$d일%n",4, 2005, 7);

		// 현재 시스템 날짜 불러오기
		Calendar now= Calendar.getInstance();
		System.out.println("\nYear=>"+now.get(Calendar.YEAR));
		System.out.println("month=>"+ (now.get(Calendar.MONTH)+1) ); // January: 0
		System.out.println("date=>"+now.get(Calendar.DATE) +"\n");
		
		//System.out.println(now);
		
		// 시스템 날짜를 format형식으로 쉽게 불러오기
		System.out.printf("%tY년 %tm월 %td일 %tH시 : %tM분 : %tS초%n" , now, now, now, now, now, now);
		// 순서 지정으로 중복 코드 줄이기
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$tH시 : %1$tM분 : %1$tS초%n" , now);
		System.out.println();
		System.out.printf("%3d %-10s %-8s %-5d%n",1,"jang","장희정",20);
		System.out.printf("%3d %-10s %-8s %-5d%n",22,"hee","정효욱",03);
		System.out.printf("%3d %-10s %-8s %-5d%n",3,"rew97","장정희",20);
		System.out.printf("%3d %-10s %-8s %-5d%n",4,"jang","장희정",20);
	}
}
