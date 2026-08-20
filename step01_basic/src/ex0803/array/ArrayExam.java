package ex0803.array;

class ArrayExam{
	
	// 각 int, double, char, boolean, String type 별로 총 5개씩 저장하는  배열을 생성하세요
	int[] iArr = new int[5];
	double[] dArr = new double[5];
	char[] cArr = new char[5];
	boolean[] bArr = new boolean[5];
	String[] sArr = new String[5];
	
	


	// 메소드 : printArrayValue01	
	// 위의 배열들에 자동으로 초기화 된값을 출력하세요
	public void printArrayValue01() {
		System.out.print("int 배열: ");
		for(int i: iArr) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.print("double 배열: ");
		for(double d: dArr) {
			System.out.print(d + " ");
		}
		System.out.println();
		System.out.print("char 배열: ");
		for(char c: cArr) {
			System.out.print(c + " ");
		}
		System.out.println();
		System.out.print("boolean 배열: ");
		for(boolean b: bArr) {
			System.out.print(b + " ");
		}
		System.out.println();
		System.out.print("String 배열: ");
		for(String s: sArr) {
			System.out.print(s + " ");
		}
		System.out.println();
		
	}
	

	// 메소드 : printArrayValue02	
	// 위의 5개의 배열에서 각각 적당한 값으로 data를 할당하세요.
	public void printArrayValue02() {
//		iArr = new int[]{1, 2, 3, 4, 5};
//		dArr = new double[] {0.1, 0.2, 0.3, 0.4, 0.5};
//		cArr = new char[] {'a', 'b', 'c', 'd', 'e'};
//		bArr = new boolean[] {true, false, false, true, false};
//		sArr = new String[] {"가", "나", "다", "라", "마"};
		
		for(int i = 0; i<5; i++) {
			iArr[i] = (i+10);
			dArr[i] = i*0.5;
			cArr[i] = (char)('A'+i);
			if(i%2==0)bArr[i] = true;
			sArr[i]="A"+i;
		}
	}
	
	// 메소드 : printArrayValue03	
	// 새롭게 할당된값을 출력하세요
	public void printAarrayValue03() {
		System.out.println();
		this.printArrayValue01();
	}
	
	// 메인메소드에서
	// ArrayExam의 메소드들을 순서대로 호출하세요.
	public static void main(String[] args) {
		ArrayExam ae = new ArrayExam();
		ae.printArrayValue01();
		ae.printArrayValue02();
		ae.printAarrayValue03();
		
	}
	
}