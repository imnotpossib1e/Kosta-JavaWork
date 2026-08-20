package ex0820;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

public class FileCopyExam {

    public FileCopyExam(String readFileName, String writeFileName) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        // step11_IOStream/src/ex0820/b.txt

        // 파일을 읽고, 해당 파일을 원하는 위치에 저장하는 코드사 -> 복사
        try {
            fis = new FileInputStream(readFileName);
            fos = new FileOutputStream(writeFileName);

            // 파일을 읽는다
            while (true) {
                int i = fis.read();
                if (i == -1) {
                    break;
                }
                // 파일을 다 읽고 저장한다.
                fos.write(i);

            }
            System.out.println("복사 완료되었습니다.");
        } catch (Exception e) {
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

        String readFileName = JOptionPane.showInputDialog("읽을 파일명은?");
        String writeFileName = JOptionPane.showInputDialog("저장할 파일명은?");

        new FileCopyExam(readFileName, writeFileName);

    }
}
