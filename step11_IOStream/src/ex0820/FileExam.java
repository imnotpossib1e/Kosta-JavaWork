package ex0820;

import java.io.File;

import javax.swing.JOptionPane;

public class FileExam {

    public FileExam() throws Exception {
        // swing : GUI 프로그래밍
        // showInputDialog: 입력창UI
        String path = JOptionPane.showInputDialog("파일경로는?");
        System.out.println(path);
        // 현재 경로
        // step11_IOStream/src/ex0820/b.txt

        // 파일객체 생성
        File file = new File(path);
        // 파일이 있는지 없는지 체크
        if (file.exists()) {
            System.out.println(path + "는 있습니다.^^");

            // 폴더인지 확인
            if (file.isDirectory()) {
                System.out.println("폴더안에 정보를 확인 해볼게요!!");
                // 파일 이름 문자열로 만든다
                String fileNames[] = file.list();
                for (String fname : fileNames) {
                    System.out.println(fname);
                }
            } else {
                // 폴더가 아닌 파일인 경우 파일 정보 가져오기
                System.out.println("**파일의 정보를 확인해볼께요!!***");
                System.out.println("file.canRead() = " + file.canRead());
                System.out.println("file.canWrite() = " + file.canWrite());
                System.out.println("file.length() = " + file.length());
                System.out.println("file.getName() = " + file.getName());
                System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
                System.out.println("file.lastModified() = " + file.lastModified());

            }

        } else {
            System.out.println(path + "가 없으니 생성할께요.");

            // 파일 생성과 폴더 생성은 동시에 할 수 없다.
            // 파일생성
            file.createNewFile();

            // 폴더 생성
//            file.mkdir();
        }

    }

    public static void main(String[] args) throws Exception {
        new FileExam();

    }

}
