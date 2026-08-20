package ex0803.overloading;

public class VariableArgsExam {

	public void aa(int ...i) { // Variable Arguments ... 사용
		// i는 배열이된다.
		System.out.println("i = " + i);
		System.out.println("\n*******************************");
	}
	
	// Variable Arguments는 인수의 가장 마지막에 와야한다.
	/*
	public void bb(String ... s , int i) {
		
	} */
	
	public void bb(int i, String ...s) {
		
	}
	
	public static void main(String[] args) {
		System.out.println("--메소드를 호출하자--");

		VariableArgsExam ve = new VariableArgsExam();
		
		ve.aa(5);
		
		ve.aa(5, 3, 1);
		ve.aa();
		ve.aa(1,2,3,4,5,6);
		
		// 인수 타입이 맞지 않아서 error
		// ve.aa("안녕"); 
	}

}
