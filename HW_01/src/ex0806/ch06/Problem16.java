package ex0806.ch06;

class Printer{
	public void println(int i) {
		System.out.println(i);
	}
	
	public void println(boolean b) {
		System.out.println(b);
	}
	
	public void println(double d) {
		System.out.println(d);
	}
	
	public void println(String s) {
		System.out.println(s);
	}
	
}

public class Problem16 {
	public static void main(String[] args) {
		Printer printer = new Printer();
		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("홍길동");
	}
	
}
