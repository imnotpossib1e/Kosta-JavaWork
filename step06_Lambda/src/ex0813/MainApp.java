package ex0813;

public class MainApp {

    public static void main(String[] args) {
        // 1. 기존방식
//        AInterface ai = new Test();
//        ai.aa();

        // 2. 익명의 이너클래스(Anonymous Inner class) 타입으로 작성(재사용 불가능)
//        AInterface ai = new AInterface() { // AInterface를 구현
//            @Override
//            public void aa() {
//                System.out.println("익명 이너클래스 aa 호출");
//            }
//        };
//        ai.aa();

        /**
         * 3. 람다식
         * 인터페이스안에 메소드가 한개 있을 경우에만 사용할 수 있다
         * FunctionalInterface
         *
         * - 인수가 없는 경우
         * () -> {}
         *
         * - 인수가 있는 경우
         * (변수 이름, ...) -> {}
         *
         * - 기능 문장이 한문장인 경우
         * () -> 기능
         */
        /*
        AInterface ai = () -> {
            System.out.println("인수가 없는 람다식 FunctionalInterface");
        };
        ai.aa();
        */
        // 중괄호 생략 - 기능 한문장일
        AInterface ai = () -> System.out.println("인수가 없는 람다식");
        ai.aa();

        BInterface bi = (a) -> System.out.println(a + "가 전달된 람다식");
        bi.bb(9);

        /*
        CInterface ci = (a, b) -> {
            return a + b;
        };
         */

        CInterface ci = (a, b) -> a + b;

        int re = ci.cc(1, 3);
        System.out.println("re = " + re);
    }
}

// 구현 객체
class Test implements AInterface {

    @Override
    public void aa() {
        System.out.println("Test의 aa 메소드 입니다.");
    }
}
