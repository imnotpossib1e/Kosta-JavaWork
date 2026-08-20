package ex0812.exam04;

/**
 * 제너릭 메소드 예제
 */
public class MainApp<B> {

    public static void main(String[] args) {

    }

    // 인수로 들어올 타입을 모를 때 사용한다.
    // 제너릭 메소드는 정의한 블록에서만 사용 가능
    public <A> void test01(A a, B b) {

    }

    // A 타입 사용 불가능
//    public B void test02(A a, B b){}

}
