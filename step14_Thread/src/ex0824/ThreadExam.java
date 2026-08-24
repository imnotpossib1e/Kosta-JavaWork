package ex0824;

import java.util.Random;

public class ThreadExam {

    public static void main(String[] args) {
        System.out.println("**** 메인 시작 ****");

        NumberThread th1 = new NumberThread("첫번째 Thread");
        NumberThread th2 = new NumberThread("두번째 Thread");

        AlphaThread alpha = new AlphaThread();
        Thread th3 = new Thread(alpha, "세번째 Thread");

        // run을 직접 호출하면 싱글메인스레드로 동작 -> 순차적 작동

        // 각 Thread의 start를 호출해서 실행 준비 상태로 만든다
        // 실행 준비 상태에 있는 스레드 중 가장 우선순위가 높은 스레드가 running 상태가 되어 서로 번갈아 가면서 일을 한다
        th1.start();
        th2.start();
        th3.start();

        // 메인이 먼저 끝나기 때문에 sum = 0으로 출력된다.
        // 따라서 th1 메소드가 일을 끝내고 진행해야 한다 -> join 사용
        /*
        try {
            th1.join(); // th1 스레드가 마무리할 때 까지 현재 스레드(메인) 정지 상태
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        System.out.println("총합 = " + th1.sum);

        System.out.println("**** 메인 끝 ****");
    }
}

/**
 * 1 ~ 100 까지 출력하는 스레드 - 상속
 */
class NumberThread extends Thread {

    int sum;

    public NumberThread(String name) {
        // Thread(String name) 생성자 호출 - 스레드를 원하는 이름으로 정하고 싶을때
        super(name);

    }

    /**
     * Thread로 작업할 기능 작성 - run() 메소드 재정의
     */
    @Override
    public void run() {
        Random r = new Random();
        for (int i = 1; i <= 100; i++) {
            // super: NumberThread
            // getName(): 스레드 이름 가져오기
            System.out.println(super.getName() + "==> " + i);
            sum += i;

            int no = r.nextInt(100); // 0 ~ 99
            /*
            try {
                Thread.sleep(no); // 10 : 0.01초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             */

            // 다른 스레드에게 실행을 양보하여 현재 스레드가 Runnable 상태로 간다
            Thread.yield();
        }
        System.out.println(super.getName() + " End");
    }
}

/**
 * a ~ z 까지 출력하는 스레드 - 구현
 */
class AlphaThread implements Runnable {

    /**
     * Thread로 작업할 기능 작성
     */
    @Override
    public void run() {
        Thread th = Thread.currentThread();
        for (char ch = 'A'; ch <= 'z'; ch++) {
            System.out.println(th.getName() + " ==> " + ch);
            /*
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             */
            Thread.yield();
        }

        System.out.println(th.getName() + " End");
    }
}