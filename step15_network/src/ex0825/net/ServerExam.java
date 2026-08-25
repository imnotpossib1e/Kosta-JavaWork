package ex0825.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;

/**
 * 서버 역할
 */
public class ServerExam {

    public ServerExam() {
        try (ServerSocket server = new ServerSocket(8000)) { // AutoCloseable
            // 서버를 계속 열려있게 하기 위해 while문 사용
            while (true) {
                System.out.println("클라이언트 접속 대기중 ...");

                Socket sk = server.accept(); // 클라이언트 접속 대기 - 클라이언트가 접속되면 수락되어 Socket 반환

                // 접속된 클라이언트 IP 조회
                String ip = sk.getInetAddress().toString();
                System.out.println(ip + " 님 접속 되었습니다.");

                // 단일 스레드이기 떄문에 서버와 클라이언트의 읽기, 전송 순서가 같아야한다.
                // 클라이언트로부터 전송된 데이터 읽기 ( 바이트 -> 문자열 -> 성능향상)
                BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
                String clientData = br.readLine();
                System.out.println("클라이언트가 보내온 내용 : " + clientData);

                // 클라이언트로 데이터 전송 -> 클라이언트의 readLine()으로 간다.
                // PrintWriter : 타입별로 보내는 메소드 제공 - 네트워크 통신에서 보내기 할때 주로 사용
                // boolean: autoFlush
                PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
                pw.println("안녕하십니까."); // println을 사용해야 autoFlush 적용
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServerExam();
    }
}
