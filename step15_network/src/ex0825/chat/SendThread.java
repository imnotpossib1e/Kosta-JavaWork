package ex0825.chat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 키보드 입력을 받아서 상대측(client or server)에게 데이터 전송하는 스레드
 */
public class SendThread extends Thread {

    private Socket sk;
    private String name;

    // 소켓과 서버인지 클라이언트인지 받음
    public SendThread(Socket sk, String name) {
        this.sk = sk;
        this.name = name;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);

        try {
            PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);

            // 입력값이 exit일때 까지 계속 입력 받는다.
            while (true) {
                // 입력받기
                String input = sc.nextLine();

                // 입력값이 exit일 때 while문 빠져나간다.
                if (input.equals("exit")) {
                    // input = "exit" -> 상대측에게 알리기 위해 보낸다
                    pw.println(input);
                    break;
                }

                // 입력받은 데이터 전송
                pw.println(name + "  " + input);

            }
            System.out.println(name + "의 스레드 종료");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("프로그램 종료");
            System.exit(0);
        }
    }
}
