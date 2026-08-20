package ex0820;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputExam {

    public FileInputOutputExam() {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            /**
             * 파일 읽기
             */
            fis = new FileInputStream("step11_IOStream/src/ex0820/a.txt");

            /* // 1byte 씩 읽기
            while (true) {
                int i = fis.read(); // 1byte씩 읽기
                if (i == -1) { // 더 문자가 없으면 -1
                    break;
                }
                System.out.println(i + " = " + (char) i);
            }*/

            // byte 크기만큼 읽기 -> 한글은 글자당 3byte
            // 큰 하일을 읽기에는 무리가 있다.
            // InputStream의 읽을 수 있는 byte 수 반환
            int len = fis.available();
            byte[] b = new byte[len];
            fis.read(b);

            // byte[]을 String 변환 (문자열로 변환)
            String str = new String(b);
            System.out.println(str);

            System.out.println("**파일 읽기 완료**");

            ///////////////////////////////////////////////

            /**
             * 파일 내용 저장 (=쓰기)
             */
            // 해당 파일이 없으면 생성해서 저장한다.
            // true: 이어쓰기
//            fos = new FileOutputStream("step11_IOStream/src/ex0820/save.txt", true);
            fos = new FileOutputStream("step11_IOStream/src/ex0820/save.txt");
            /*
            fos.write(65); // A
            fos.write(66); // B
            fos.write(67); // C

            fos.write(13); // 줄바꿈
            fos.write(10); // 줄바꿈

            fos.write(70); // F

            // String -> byte[] 로 변환
            String data = "안녕하세요";
            fos.write(data.getBytes());
           */
            fos.write(b);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }

                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new FileInputOutputExam();
    }
}
