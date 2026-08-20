package ex0729.연산자;

class BooleanOPeratorExam{
	public static void main(String args[]){
		boolean  t=true ;
		boolean f=false;
		
		// & 양쪽 모두 true면 true
		System.out.println("true&false="+(t&f)); // true&false=false
		System.out.println("true&true="+(t&t)); // true&true=true
		System.out.println("false&false="+(f&f)); // true&false=false
		System.out.println();
	
		// | 양쪽 중 하나만 true면 true 
		System.out.println("true|false="+(t|f)); // true|false=true
		System.out.println("true|true="+(t|t)); // true|false=true
		System.out.println("false|false="+(f|f)); // true|false=false
		System.out.println();

		// ^ 양쪽이 같으면 false, 양쪽이 다르면 true
		System.out.println("true^false="+(t^f)); // true^false=true
		System.out.println("true^true="+(t^t)); // true^true=false
		System.out.println("true^false="+(t^f)); // true^false=true
		System.out.println("true^true="+(t^t)); // true^false=false
		System.out.println();
		
		// && 둘 다 true면 true
		System.out.println("true&&false="+(t&&f)); // true&&false=false
		System.out.println("true&&true="+(t&&t)); // true&&true=true
		System.out.println("true&&false="+(t&&f)); // true&false=false
		System.out.println("false&&false="+(f&&f)); // false&&false=false
		System.out.println();

		// || 둘 중 하나가 true면 true
		System.out.println("true||false="+(t||f)); // true||false=true
		System.out.println("true||true="+(t||t)); // true||true=true
		System.out.println("false||false="+(f||f)); // false||false=true
		System.out.println();

		int i=5; int j=3;
		System.out.println("int i="+i+"\tint j="+j); // int i=+5 int j= 3
		System.out.println("i>=j==>>"+(i>=j)); // i>=j==>>true
		System.out.println("i>j=>>"+(i>j)); // i>j=>>true
		System.out.println("i<=j=>>"+(i<=j)); // i<=j=>>false
		System.out.println("i<j=>>"+(i<j)); // i<j=>>false
		System.out.println("i==j=>>"+(i==j)); // i==j=>>false
		System.out.println("i!=j=>>"+(i != j)); // i!=j=>>true
		
		// | 와 || 비교
		System.out.println("결과 : " + (true | test())); // 앞이 true여도 뒤의 연산 진행 O -> test() 호출 O
		System.out.println("결과 : " + (true || test())); // 앞이 true라서 뒤의 연산 진행 X -> test() 호출 X
		

	}
	
	// 테스트 메소드 작성
	public static boolean test() {
		System.out.println("test call...");
		return true;
	}
}