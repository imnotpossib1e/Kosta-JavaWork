package ex0806.ch06;

class Printer2{
	public static void println(int i) {
		System.out.println(i);
	}
	
	public static void println(boolean b) {
		System.out.println(b);
	}
	
	public static void println(double d) {
		System.out.println(d);
	}
	
	public static void println(String s) {
		System.out.println(s);
	}
	
}

public class Problem17 {

	public static void main(String[] args) {
		Printer2.println(10);
		Printer2.println(true);
		Printer2.println(5.7);
		Printer2.println("홍길동");

	}

}
