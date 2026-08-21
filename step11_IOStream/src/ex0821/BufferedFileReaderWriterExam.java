package ex0821;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class BufferedFileReaderWriterExam {

    public BufferedFileReaderWriterExam() {
        // 문자 단위로 파일 읽기 / 쓰기(저장) -> Buffered 이용
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 객체 생성
            br = new BufferedReader(new FileReader("step11_IOStream/src/ex0820/a.txt"));
//            br = new BufferedReader(
//                new FileReader("step11_IOStream/src/ex0820/BufferedFileCopyExam.java"));

            // 한 문자씩 읽기
            /*
            int i = 0;
            while ((i = br.read()) != -1) {
                System.out.println(i + " = " + (char) i);
            }
             */

            // 한 줄씩 읽기
            String str = null;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }

            // 저장
            bw = new BufferedWriter(new FileWriter("step11_IOStream/src/ex0821/save.txt"));
            bw.write("쉬고싶어요\n");
            bw.write("언제쉬지");
            bw.newLine(); // 개행
            bw.write("ㅇㄴ");
            bw.flush(); // Buffer에 있는 내용 출력(버퍼 비우기)

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new BufferedFileReaderWriterExam();
    }
}
