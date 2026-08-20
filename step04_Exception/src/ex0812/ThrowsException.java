package ex0812;

public class ThrowsException {

    public void aa(int i) throws ArithmeticException { // bb에서 throw한 예외를 던진다
        System.out.println("aa 시작");
        try {
            this.bb(i); // bb에서 throw한 예외 도착
        } finally {
            System.out.println("aa 끝");
        }
    }

    // throw 던지고자하는 예외
    public void bb(int i) throws ArithmeticException, NullPointerException {
        System.out.println("bb 시작");
        try {
            int result = 100 / i; // i가 0이면 ArithmeticException 발생 가능성
            System.out.println("나눈 결과 = " + result);
        } finally {
            System.out.println("bb 끝");
        }

    }

    // 메인에서의 예외 처리는 거의 사용 X, 임시로 컴파일 해볼때만?
    public static void main(String[] args) /*throws ArithmeticException*/ {
        System.out.println("*** 메인 시작 ***");

        ThrowsException te = new ThrowsException();
        try {
            te.aa(10); // aa에서 throw한 예외 도착
        } catch (ArithmeticException e) {
            System.out.println("메인이 예외처리 했어요..");
            e.printStackTrace();
        }

        System.out.println("*** 메인 끝 ***");
    }
}
