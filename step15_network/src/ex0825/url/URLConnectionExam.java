package ex0825.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class URLConnectionExam {

    /**
     * 원격의 url 데이터 가져오기
     * daum.net의 메인 소스를 저장
     */
    public URLConnectionExam() {
        try {
            URL url = new URI("https://www.daum.net/").toURL();

            // byte 단위로 읽기
            InputStream is = url.openStream();
            // Reader로 바꾸고 성능 향상
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            BufferedWriter bw = new BufferedWriter(
                new FileWriter("step15_network/src/ex0825/url/daum.html"));

            while (true) {
                String data = br.readLine();
                if (data == null) {
                    break;
                }
                bw.write(data);
                bw.newLine();
            }

            System.out.println("완료되었습니다.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new URLConnectionExam();

    }

}