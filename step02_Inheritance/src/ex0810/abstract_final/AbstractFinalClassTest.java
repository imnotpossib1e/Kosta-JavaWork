package ex0810.abstract_final;//Error 를 수정하고 이유를 주석으로 처리하세요.

// Final
final class FinalClassExam { // 상속 불가, 생성 가능

    final int i = -999999; // 값 변경 불가
}

// Abstract
abstract class AbstractClassExam { // 상속 가능, 생성 불가

    abstract String abstractMethodExam(int i, String s); // body 없음. 재정의를 위함

    final int finalMethodExam(int i, int j) {
        return i + j;
    } // 재정의 불가능
}


class Sample01 extends AbstractClassExam {

    String abstractMethodExam(int i, String s) {
        System.out.println("return " + s + i);
        return s + i;
    }

    // 부모의 final 메소드는 재정의 불가능
//    int finalMethodExam(int i, int j) {
//        return i * j;
//    }

}

// final 클래스는 상속 불가능
class Sample02 /*extends FinalClassExam*/ {

}

// abstract 클래스를 상속받으려면 abstract 클래스여야한다.
abstract class Sample03 extends AbstractClassExam {
    // 오버라이딩
    String abstractMethodExam(int i, String s) {
        return s + i;
    }

    // 오버로딩
    abstract String abstractMethodExam(String s, int i);

    void sampleMethod03() {
        System.out.println("void sampleMethod03() 호출 됨");
    }
}

class AbstractFinalClassTest {

    public static void main(String args[]) {
        // absctract 클래스는 생성 불가능
        AbstractClassExam ace /*= new AbstractClassExam()*/;
        FinalClassExam fce = new FinalClassExam();
        // final 필드는 값 변경 불가능
//        fce.i = 100000;
        Sample01 s01 = new Sample01();
        AbstractClassExam aceS01 = new Sample01();
        aceS01.abstractMethodExam(700, "_999");
    }
}
