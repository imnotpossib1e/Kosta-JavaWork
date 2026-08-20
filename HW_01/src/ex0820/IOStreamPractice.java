package ex0820;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class IOStreamPractice {

    public IOStreamPractice(String name, String weight, String password) {
        BufferedOutputStream bos = null;
        String filename = name + ".txt";
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("이미 존재하므로 다시 입력하세요");
        } else {
            try {
                // 파일 생성
                bos = new BufferedOutputStream(new FileOutputStream(file));
                String data = weight + ":" + password;
                bos.write(data.getBytes());
                System.out.println("프로필 저장 완료");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bos != null) {
                        bos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public IOStreamPractice(String name) {
        BufferedInputStream bis = null;
        String filename = name + ".txt";
        try {
            // 읽을 파일 찾기
            bis = new BufferedInputStream(new FileInputStream(filename));

            int len = bis.available();
            byte[] b = new byte[len];
            bis.read(b);

            String str = new String(b);
            String[] info = str.split(":");

            System.out.printf("%s님 몸무게는 %skg 이고 비번은 %s 입니다.\n", name, info[0], info[1]);

        } catch (Exception e) {
            System.out.printf("%s에 해당하는 정보는 없습니다.\n", name);
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 프로필 저장 \t 2. 프로필 불러오기 \t 3. 종료");
            String choice = sc.nextLine();
            switch (choice) {
                case "1": {
                    System.out.print("이름 : ");
                    String name = sc.nextLine();
                    System.out.print("몸무게 : ");
                    String weight = sc.nextLine();
                    System.out.print("비밀번호 : ");
                    String password = sc.nextLine();
                    new IOStreamPractice(name, weight, password);
                    break;
                }
                case "2": {
                    System.out.print("이름 : ");
                    String name = sc.nextLine();
                    new IOStreamPractice(name);
                    break;
                }
                case "3": {
                    System.exit(0);
                }
                default: {
                    System.out.println("다시 입력해주세요.");
                }
            }
        }
    }

}
