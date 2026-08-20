package ex0730.제어문;

public class ForExam01 {

	public static void main(String[] args) {
		//1. 1~ 100가지 한줄로 출력 
		for(int i = 1; i<=100; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		//2. A ~Z 까지 한줄로 출력 
		for(char c = 'A'; c<='Z'; c++) {
			
			System.out.print(c + " ");
		}
		
		System.out.println();

		for(int i = 0; i < 26; i++) {
			System.out.print((char)('A'+i) + "\t");
		}
		
		System.out.println();
		
		//3. 1~ 10 까지 합 구해서 출력 
		int sum=0;
		for(int i = 1; i<=10; i++) {
			sum +=i;
		}
		
		System.out.println(sum);
		
		//4. 1 ~ 100 사이의 7의 배수만 출력 
		for(int i = 1; i<=100; i++){
			if(i%7==0) {
				System.out.print(i + " ");
			}
		}
		
		System.out.println();
		
		
		//5. 100 ~ 1 사이의 5 의 배수만 출력
		for(int i = 100; i>=1; i--) {
			if(i%5==0) {
				System.out.print(i + " ");
			}
		}
	}
}
