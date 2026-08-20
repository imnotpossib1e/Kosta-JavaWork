package ex0731.method;


/**
 * @author 이진현
 * 날짜: 260731
 * 주제: 메소드 4번 예제
 */
// UsingMethod.java
class UsingMethodExam{
     // 아래와 같은 메소드를 작성하세요.
   
     /* Method 이름 :  methodExam03_01
      * 자기자신만 접근가능
      * ReturnType : 정수
      * Parameter : 정수 1개
      * (구현부에서)하는 일 : 
      * methodExam03_01이 호출되었습니다. 출력
      * 인수로 받은 정수 출력 
      * 정수*2 리턴. 
      * */
	private int methodExam03_01(int i) {
		System.out.println("methodExam03_01이 호출되었습니다.");
		System.out.println("인수: " + i);
		return i * 2;
	}
		
	
	 
	/* Method 이름 :  methodExam03_02
	  * 어디서나 아무나 접근가능
	  * Return String
	  * Parameter : String 1개, 정수 1개
	  * (구현부에서)하는 일 : 
	  * methodExam03_02가 호출되었습니다. 출력
	  * 인수로 받은 String 에 바보를 붙여서 출력
	  * 두번째인수로 들어온 값을 methodExam03_01로 넣어 주며 methodExam03_01을 호출하고 리턴하는 값을 출력
	  * 인수로 받은 String 에 바보를 붙여서 리턴
	  * */	
	public String methodExam03_02(String s, int i) {
		System.out.println("methodExam03_02가 호출되었습니다.");
		System.out.println(s +"바보");
		System.out.println(this.methodExam03_01(i));
		return s + "바보";
	}
			
	
	/* Method 이름 :  methodExam03_03
	 * 같은 package 에서 아무나 접근 가능
	 * ReturnType : 리턴안함
	 * Parameter : 정수 1개와 String 1개
	 * (구현부에서)하는 일 : 
	 * methodExam03_03이 호출되었습니다. 출력
	 * 인수로 받은 정수 1개와 String 1개를 넘겨주며methodExam03_02호출
	 * */	
	void methodExam03_03(int i, String s) {
		System.out.println("methodExam03_03이 호출되었습니다.");
		methodExam03_02(s, i); // this 생략 가능
	}
	
	
	/* Method 이름 :  methodExam03_04
	 * 상속관계라면 어디서나 접근 가능
	 * ReturnType : 실수(부동소수형)
	 * Parameter : 첫번째 인수(정수),두번째 인수(실수), 세번째인수(정수)
	 * (구현부에서)하는 일 : 
	 * methodExam03_04가 호출되었습니다. 출력인수로 들어온 값을 이용해 
	 * MakeMethodExam02객체의 methodExam02_04메소드 호출하고
	 * method02_04가 리턴하는 값을 리턴
	 * */	
	protected double methodExam03_04(int a, double d, int b) { 
		System.out.println("methodExam03_04이 호출되었습니다.");
		MakeMethodExam02 mme = new MakeMethodExam02();
		return mme.methodExam02_04(a, d, b);
	}
	
		
} // UsingMethodExam 끝

class UsingMethod{
	// 메인메소드에서
	// UsingMethodExam의 호출가능한 메소드들을 호출하고
	// 리턴하는 값 있다면 출력
	
	public static void main(String[] args) {
		UsingMethodExam ume = new UsingMethodExam();
		
		// methodExam03_01: private타입이라 호출 불가능
		
		System.out.println("methodExam03_02 호출");
		String s = ume.methodExam03_02("안녕", 3);
		System.out.println(s);
		
		ume.methodExam03_03(1, "gkdl");
		
		System.out.println("methodExam03_04 호출");
		double s2 = ume.methodExam03_04(1, 1.43, 2);
		System.out.println(s2);
	}
	
}

  
