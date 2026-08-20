package ex0812;

public class ExceptionReturnExam {

    public void aa(int i) {

        try {
            if (i == 0) {
                // 예외 강제 발생
                throw new RuntimeException();

//                return; // 메소드 탈출 (finally는 실행된다)
//                System.exit(0); // 프로그램 강제 종료(finally도 실행되지 않음)
            }
            System.out.println(i + " 입니다.");
        } finally { // finally는 return을 만나도 무조건 실행된다
            System.out.println("---aa 끝---");
        }

    }

    public static void main(String[] args) {
        System.out.println("*** 메인 시작 ***");

//        new ExceptionReturnExam().aa(10);
        new ExceptionReturnExam().aa(0);
        System.out.println("*** 메인 끝 ***");
    }

}
