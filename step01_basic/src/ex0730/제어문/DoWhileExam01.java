package ex0730.제어문;

public class DoWhileExam01 {

	public static void main(String[] args) {
		//1. 1~ 100가지 한줄로 출력
		int i = 1;
		do {
			System.out.print(i + " ");
			i++;
		}while(i<=100);
		
		System.out.println();

		//2. A ~Z 까지 한줄로 출력
		char c = 'A';
		do {
			System.out.print(c + " ");
			c++;
		}while(c <= 'Z');
		
		System.out.println();

		//3. 1~ 10 까지  합 구해서 출력
		i = 1;
		int sum = 0;
		do {
			sum += i;
			i++;
		}while(i<=10);
		
		System.out.println(sum);

		//4. 1 ~ 100 사이의 7의 배수만 출력 
		i = 1;
		do {
			if(i%7==0) {
				System.out.print(i + " ");
			}
			i++;
		}while(i<=100);
		
		System.out.println();
		
		//5. 100 ~ 1 사이의 5 의 배수만 출력 
		i = 100;
		do {
			if(i%5==0) {
				System.out.print(i + " ");
			}
			i--;
		}while (i >= 1);
		
		System.out.println();
					
		//1.  1 ~ 100가지 10행 10열로 출력 (do_while문 안에 do_while문이용)
		i = 0;
		do {
			int j = 1;
			do {
				System.out.print((i * 10) + j + " ");
				j++;
			}while(j <=10);
			System.out.println();
			i++;
		}while(i <10);
		
		System.out.println();
		
		//2. 1 ~ 100가지 10행 10열로 출력 (do_while문 안에  if문이용)
		i = 1;
		do {
			if(i%10==0) {
				System.out.println(i);
			}else {
				System.out.print(i + " ");
			}
			i++;
		}while(i<=100);
		

		//3. 구구단 출력  -  do_while 문안에 do_while문이용
		i = 1;
		do {
			int j = 2;
			do {
				System.out.print(j + " * " + i + " = " +  i*j + "\t");
				j++;
			}while(j<=9);
			System.out.println();
			i++;
		}while(i<=9);

	}

}
