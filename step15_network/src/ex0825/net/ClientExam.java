package ex0825.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 클라이언트 역할
 */
public class ClientExam {

    public ClientExam() {
        try (Socket sk = new Socket("192.168.0.14", 8000)) { // 서버에 접속 요청을 보낸다

            // 단일 스레드이기 떄문에 서버와 클라이언트의 읽기, 전송 순서가 같아야한다.
            // 서버에 데이터 전송
            PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
            pw.println("서버에 접속하고싶어요"); // 서버의 readLine()으로 간다

            // 서버가 보낸 데이터 읽기
            BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            String clientData = br.readLine();
            System.out.println("서버 보내온 내용 : " + clientData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClientExam();
    }
}
