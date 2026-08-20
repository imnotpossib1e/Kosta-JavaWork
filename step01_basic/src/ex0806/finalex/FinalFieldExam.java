package ex0806.finalex;

/**
 * final 필드는 반드시 초기화 필수
 * 1. 직접 명시적 초기화
 * 2. 생성자 안에서 초기화
 * 
 * static final 필드는 상수이다
 * 1. 직접 명시적 초기화
 * 2. 생성자 안에서 초기화 불가능
 * 3. static 블럭 안에서 초기화 가능
 */
public class FinalFieldExam {

	int i;
	
	// final: 값 변경 불가인 고정 값
	
	// 명시적 초기화
	// final int j = 100;

	// 생성자 안에서 초기화
	final int j;
	
	// static final은 생성자 내에서 초기화가 불가능
	// static final은 명시적 초기화만 가능하다 -> 상수 = constant
	static final int K = 100;
	
	// static final은 static 블럭에서 초기화 가능하다
	static final int H;
	
	static {
		H = 100;
	}

	
	// 생성자 안에서 초기화
	public FinalFieldExam() {
		j = 100;
	}
	
	// 생성자가 생성될 때 final 변수에 값 넣어주기
	public FinalFieldExam(int k) {
		this.j=k;
	}
	
	
	
	public static void main(String[] args) {
		FinalFieldExam fe = new FinalFieldExam();
		fe.i = 5; // 값 변경
		
//		fe.j = 6; // fianl 필드는 값 변경 불가능
		
		// 생성자가 생성될 때 final 변수에 값 넣어주기
		FinalFieldExam fe2 = new FinalFieldExam(3);
		

	}

}
