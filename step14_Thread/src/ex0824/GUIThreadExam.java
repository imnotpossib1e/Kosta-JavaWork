package ex0824;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

// 창 역할 - Container
public class GUIThreadExam extends JFrame {

    // 한줄 입력 - (글자수)
    JTextField text1 = new JTextField(5);
    JTextField text2 = new JTextField(5);

    // 버튼
    JButton btn1 = new JButton("버튼");

    boolean state = true;

    public GUIThreadExam() {
        // 타이틀 설정
        super("시계 공간");

        // JFrame의 레이아웃(배치도) 변경 - Flow 레이아웃으로 변경(기본: border레이아웃)
        super.setLayout(new FlowLayout());

        // component를 JFrame 위에 올리기
        Container con = super.getContentPane();
        super.add(btn1);
        super.add(text1);
        super.add(text2);

        // 창 크기 설정
        super.setSize(500, 400);

        // 창 중앙 배치(창 크기 설정시에만 가능)
        super.setLocationRelativeTo(null);

        // 창 보이기 - 기본이 숨김
        super.setVisible(true);

        // 창 끄면 프로그램 종료
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Inner Class 사용 없이 다른 클래스 요소에 접근
         *
         * 스레드 시작
         */
//        new NowTimeThread(this).start();

        /**
         * inner class 사용
         *
         * 시계 스레드 시작
         */
        new NowTimeThread().start();

        /**
         * 람다 함수 사용해서 스레드 생성
         *
         * 1 ~ 1000 까지
         */
        new Thread(() -> {
            // run 메소드 안
            for (int i = 1; i <= 1000; i++) {
                text1.setText(i + ""); // 문자만 넣을 수 있다.

                // 딜레이 주기 위함
                try {
                    Thread.sleep((int) (Math.random() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        /**
         * 버튼이 눌리면 실행되는 스레드 - 이벤트 핸들러
         * 스레드가 실행중이면 버튼이 안눌리도록
         *
         * A - z 출력
         */
//        btn1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });

        btn1.addActionListener(e -> {
            if (state) {
                state = false;
                new Thread(() -> {
                    for (char ch = 'A'; ch <= 'z'; ch++) {
                        text2.setText(ch + "");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    state = true;
                }).start();
            }
        });
    }

    public static void main(String[] args) {
        new GUIThreadExam();
    }


    /**
     * 현재 시간을 구해서 JFrame title에 1초마다 갱신하는 스레드
     * inner class
     */
    class NowTimeThread extends Thread {

        /**
         * Inner Class 사용 없이 다른 클래스의 요소에 접근
         */
        /*GUIThreadExam gui;

        NowTimeThread(GUIThreadExam gui) {
            this.gui = gui;
        }*/
        @Override
        public void run() {
            while (true) {
                // 현재 시간 구한다
                Calendar now = Calendar.getInstance();

                int y = now.get(Calendar.YEAR);
                int m = now.get(Calendar.MONTH) + 1;
                int d = now.get(Calendar.DATE);

                int h = now.get(Calendar.HOUR);
                int mn = now.get(Calendar.MINUTE);
                int s = now.get(Calendar.SECOND);

                StringBuilder sb = new StringBuilder();
                sb.append(y);
                sb.append("년 ");
                sb.append(m);
                sb.append("월 ");
                sb.append(d);
                sb.append("일  ");

                sb.append(h);
                sb.append("시 ");
                sb.append(mn);
                sb.append("분 ");
                sb.append(s);
                sb.append("초 ");

                /**
                 * Inner Class 사용 없이 다른 클래스의 요소에 접근
                 *
                 * JFrame의 title에 시계 넣기
                 */
//            gui.setTitle(sb.toString());

                /**
                 * inner class 사용
                 *
                 * JFrame의 title에 시계 넣기
                 */
                // outerClass.this로 접근
                GUIThreadExam.this.setTitle(sb.toString());

                // 1초마다 시간을 가져올 수 있도록
                try {
                    Thread.sleep(1000); // 1초 대기
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

