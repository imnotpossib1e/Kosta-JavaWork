package ex0825.multiChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerGuiChatExam {

    // 클라이언트 스레드 저장할 리스트 생성
    List<ClientSkThread> list = new ArrayList<ClientSkThread>();
    // 이너클래스에서 생성자 없이 사용 가능하도록 멤버에 선언
    Socket sk;

    public ServerGuiChatExam() {
        // 서버는 늘 돌고 있어야 한다 - 중계 서버
        try (ServerSocket server = new ServerSocket(8002)) {
            while (true) {
                System.out.println("Client 접속 대기 ...");
                sk = server.accept(); // 클라이언트 접속 대기

                ClientSkThread th = new ClientSkThread();
                th.start();

                System.out.println(sk.getInetAddress() + "님이 접속했습니다.");
                System.out.println("현재 접속 인원 : " + list.size() + "명\n");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 모든 client에게 데이터 전송하는 메소드
     */
    public void sendMessage(String message) {
        for (ClientSkThread th : list) {
            th.pw.println(message); // 클라이언트로 메시지 전달
        }
    }

    /**
     * 닉네임 중복 처리
     */
    public boolean nickNameDuplicate(String nickName) {
        for (ClientSkThread th : list) {
            if (nickName.equals(th.nickName)) {
                return false; // 중복
            }
        }
        return true; // 성공
    }

    /**
     * 접속한 클라이언트의 sk을 Thread로 만들어서 관리
     */
    class ClientSkThread extends Thread {

        PrintWriter pw;
        BufferedReader br;
        String nickName;

        ClientSkThread() {
            try {
                pw = new PrintWriter(sk.getOutputStream(), true); // 데이터 전송
                br = new BufferedReader(
                    new InputStreamReader(sk.getInputStream())); // 클라이언트가 보낸 데이터 읽기
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            // 클라이언트가 보내온 내용을 읽어서 접속한 모든 클라이언트에게 전송
            try {
                while (true) {
                    nickName = br.readLine(); // 닉네임 받아오기 - 1번만
                    if (nickNameDuplicate(nickName)) {
                        pw.println("OK");
                        list.add(this);
                        break;
                    } else {
                        pw.println("DUPLICATE");
                    }
                }

                // 이름을 접속한 모든 client에게 전송
                sendMessage("[" + nickName + "]님이 입장했습니다.");

                while (true) {
                    String inputData = br.readLine(); // 채팅 받아오기
                    if (inputData == null) {
                        break;
                    }
                    sendMessage("[" + nickName + "]  " + inputData);
                }
            } catch (Exception e) { // 클라이언트 한명이 창 엑스를 누르고 끄면 catch로 온다
                /*// 현재 스레드를 list에서 제거
                list.remove(this);

                // 남은 클라이언트에게 메시지 전송
                sendMessage("[" + nickName + "]님이 퇴장했습니다.");

                // 콘솔에 메시지 출력
                System.out.println("[" + nickName + "]님 퇴장 | 현재 인원: " + list.size() + "명");*/
            } finally {
                // catch 블럭에 넣었을 떄 macOS에서 프로그램 종료를 했을 떄 null값을 무한 출력하는 오류가 있어
                // finally에서 제거 코드를 작성
                // 현재 스레드를 list에서 제거
                list.remove(this);

                // 남은 클라이언트에게 메시지 전송
                sendMessage("[" + nickName + "]님이 퇴장했습니다.");

                // 콘솔에 메시지 출력
                System.out.println("[" + nickName + "]님 퇴장 | 현재 인원: " + list.size() + "명");
            }
        }
    }

    public static void main(String[] args) {
        new ServerGuiChatExam();
    }
}
