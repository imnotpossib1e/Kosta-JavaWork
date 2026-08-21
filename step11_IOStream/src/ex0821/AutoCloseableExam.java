package ex0821;

import java.io.Closeable;
import java.io.IOException;

class Test implements AutoCloseable {

    @Override
    public void close() throws Exception {
        // try를 빠져나갈 때 자동 호출된다.
        System.out.println("close 호출됨");
    }
}

public class AutoCloseableExam {

    public static void main(String[] args) {
        System.out.println("--- 시작 ---");
        try (Test t = new Test()) {
            System.out.println(t);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("--- 끝 ---");
    }
}
