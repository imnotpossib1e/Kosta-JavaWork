package ex0807.inheritance;

class CarCenter {
	public void engineer(Car cd) {

		// System.out.println(cd.i); // 부모타입은 자식에게 접근할 수 없다.

		// 부모 타입을 자식 타입 변수에 담는다(ObjectDownCasting)
		// 다운캐스팅을 해야하는 경우만 다운캐스팅 하도록 조건문
		//
		if (cd instanceof EfSonata) {
			EfSonata e = (EfSonata) cd;
			System.out.println(e.i);
		}

		System.out.print(cd.carname + " 수리완료!\t");
		System.out.println("청구비용" + cd.cost + " 원");

	}

	// 다형성이 없었다면 오버로딩을 이용해
	// EfSonata 타입, ...등의 타입 인수를 받는 메소드를 하나하나 만들어줬어야한다.
}

public class PolymorphismExam {
	public static void main(String[] args) {

		CarCenter cc = new CarCenter();

		EfSonata ef = new EfSonata();
		Carnival ca = new Carnival();
		Excel ex = new Excel();

		Car c = new Car();

		System.out.println("c = " + c);
		System.out.println("ef = " + ef);
		System.out.println("ca = " + ca);
		System.out.println("ex = " + ex);

		System.out.println("ef.i = " + ef.i);

//		cc.engineer(c); // Car cd = c -> Car타입
		// Polymorphism 다형성
		cc.engineer(ef); // Car cd = ef -> EfSonata타입
//		cc.engineer(ca); // Car ca = ca -> Carnival 타입
//		cc.engineer(ex); // Car cd = ex -> Excel 타입

		// CarCenter의 cd변수가 EfSonata 타입의 주소값을 가리킨다 -> 다형성

	}
}
