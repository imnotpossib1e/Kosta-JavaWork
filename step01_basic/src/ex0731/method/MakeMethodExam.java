package ex0731.method;


// MakeMethodExam.java
class MakeMethodExam{
	public static void main(String []args){
		MakeMethodExam mme=new MakeMethodExam();
		int k=mme.methodExam01(33);
		System.out.println(k);
		mme.methodExam02();
		mme.methodExam03(42);
		String s = mme.methodExam04(17);
		System.out.println(s);

	}


	/*
	 * Method 이름 : methodExam01
	 * 자기자신만 접근가능
	 * Return Type : 정수
	 * Parameter : 정수1개
	 * (구현부에서)하는일 : 
	 * 인수로 받은(들어온)정수를 출력하고 인수에 2를 곱해 Return
	 */
	private int methodExam01(int num) {
		System.out.println("인수는 " + num);
		
		
		return num * 2;
	}
	

	/*
	 * Method 이름 : methodExam02
	 * 어디에서나 아무나 접근가능
	 * Return 안함	
	 * Parameter 없음
	 * (구현부에서)하는일 : 아무거나 출력
	 */
	public void methodExam02() {
		System.out.println("출력");
	}

	
	
	/*
	 * Method 이름 : methodExam03
	 * 같은 package 내에서 아무나 접근가능
	 * Return Type : Return 안함
	 * Parameter : 정수1개	
	 * (구현부에서)하는일 : 인수로 받은(들어온) 정수를 출력하고
	 * 그수가 짝수라면 "짝수",홀수라면"홀수" 출력
	 */
	void methodExam03(int i) {
		System.out.println("인수: " + i);
		if(i % 2 == 0) {
			System.out.println(i + "은 짝수");
		}else {
			System.out.println(i + "은 홀수");
		}
	}
	

	/*
	 * Method 이름 : methodExam04
	 * 상속관계라면 어디서나 접근가능
	 * Return Type : String 타입
	 * Parameter : 정수1개	
	 * (구현부에서)하는일 : 인수로 받은(들어온) 정수를 출력하고
	 * 그수가 짝수라면 "짝수",홀수라면"홀수" 리턴
	 */
	protected String methodExam04(int i) {
		System.out.println("인수: " + i);
		if(i % 2 == 0) {
			return "짝수";
		}else {
			return "홀수";
		}
	}
	
	
}// classEnd

