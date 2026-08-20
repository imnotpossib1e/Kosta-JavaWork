package ex0730.제어문;

public class ForExam02 {

	public static void main(String[] args) {
		//1.  1 ~ 100가지 10행 10열로 출력 (for문 안에 for문이용)
		for(int i = 0; i<10; i++) { // a=0, 10, 20, 30, 40...100
			for(int j = 1; j <= 10; j++) { // b=1, 2, 3, 4...10
				System.out.print((i * 10) + j + " ");
			}
			System.out.println();
		}
		
		System.out.println();
	
		
		//2. 1 ~ 100가지 10행 10열로 출력 (for문 안에  if문이용)
		for(int i = 1; i<=100; i++) {
			if(i%10==0) {
				System.out.println(i);
			}else {
				System.out.print(i + " ");
			}
		}
		
		System.out.println();
		
		//3. 구구단 출력  -  for 문안에 for문 이용
		for(int i = 1; i<10; i++) {
			for(int j = 2; j<10; j++) {
				System.out.print(j + " * " + i + " = " + i*j + "\t");
			}
			System.out.println();
		}
		

	}

}
