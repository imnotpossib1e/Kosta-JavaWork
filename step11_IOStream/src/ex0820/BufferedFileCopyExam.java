package ex0820;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

public class BufferedFileCopyExam {

    public BufferedFileCopyExam(String readFileName, String writeFileName) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        // step11_IOStream/src/ex0820/b.txt

        // 파일을 읽고, 해당 파일을 원하는 위치에 저장하는 코드 -> 복사
        try {
            bis = new BufferedInputStream(new FileInputStream(readFileName));
            bos = new BufferedOutputStream(new FileOutputStream(writeFileName));

            // 파일을 읽는다
            while (true) {
                int i = bis.read();
                if (i == -1) {
                    break;
                }
                // 읽은 것을 저장한다.
                bos.write(i);
            }
            System.out.println("복사 완료되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        String readFileName = JOptionPane.showInputDialog("읽을 파일명은?");
        String writeFileName = JOptionPane.showInputDialog("저장할 파일명은?");

        new BufferedFileCopyExam(readFileName, writeFileName);

    }
}
