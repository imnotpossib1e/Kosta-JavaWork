package ex0807.report.inheritance;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Employee 타입 배열 선언
		Employee[] emp = new Employee[5];

		// Employee는 abstract 클래스이기 때문에 생성 불가능
//		new Employee();

		// 자식 객체를 부모 타입 배열에 저장
		// Polymorphism
		emp[0] = new FullTime(10, "유재석", "개그우먼", 0, "2013-05-01", "무한도전", 8500, 200);
		emp[1] = new FullTime(20, "박명수", "가수", 10, "2013-06-20", "무한도전", 7500, 100);
		emp[2] = new FullTime(30, "정준하", "예능인", 10, "2013-06-22", "무한도전", 6000, 0);

		emp[3] = new PartTime(40, "노홍철", "예능인", 20, "2014-05-01", "무한도전", 20000);
		emp[4] = new PartTime(50, "하하", "가수", 30, "2014-05-02", "무한도전", 25000);

		// 출력
		// 부모 타입이더라도 재정의된 메소드는 자식클래스의 메소드 호출된다
		System.out.println("*************** Emp 정보 ***************");
		for (Employee e : emp) {
			System.out.println(e);
		}

		System.out.println("*************** Emp Message 정보 ***************");
		for (Employee e : emp) {
			e.message(); // 재정의된 메소드 호출
		}
	}

}
