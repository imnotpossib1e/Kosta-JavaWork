package ex0825.chat;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * client와 1:1 채팅을 위한 Server
 */
public class ServerChatExam {

    public ServerChatExam() {

        ServerSocket server;
        // 한명이 접속하면 메인 스레드는 끝나고 읽기, 받기 스레드는 유지된다.
        // 따라서 AutoCloseable 사용 X
        try {
            server = new ServerSocket(8001);
            System.out.println("클라이언트 접속 대기중 ...");
            Socket sk = server.accept();

            System.out.println(sk.getInetAddress() + " 님과 대화 시작합니다.");

            // 보내는 스레드 - 공통 클래스 사용
            // 소켓과 서버임을 전송
            new SendThread(sk, "[SERVER]").start();

            // 받는 스레드 - 람다 사용
            new Thread(() -> {
                try {
                    BufferedReader br = new BufferedReader(
                        new InputStreamReader(sk.getInputStream()));

                    // 보내는 사람이 exit를 보내면 종료
                    while (true) {
                        String readData = br.readLine();
                        if (readData.equals("exit")) {
                            break;
                        }
                        // 받아온 메시지 화면에 출력
                        System.out.println(readData);
                    }

                    System.out.println("서버 받는 스레드 종료");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.exit(0);
                }
            }).start();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServerChatExam();
    }
}
