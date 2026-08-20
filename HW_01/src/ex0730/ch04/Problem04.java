package ex0730.ch04;

public class Problem04 {

	public static void main(String[] args) {
		int sum = 0;
		
		while(sum != 5) {
			int a = (int)(Math.random()*7 +1);
			int b = (int)(Math.random()*7 +1);
			System.out.print("("+a+", "+b+")\t");
			sum = a + b;
			System.out.println("주사위 합: " + sum);
		}
		System.out.println("*****************************");
		
		while(true) {
			int a = (int)(Math.random()*7 +1);
			int b = (int)(Math.random()*7 +1);
			System.out.println("("+a+", "+b+")\t");
			
			if(a + b == 5) break;
		}
		System.out.println("주사위 합: " + sum);
	}

}
