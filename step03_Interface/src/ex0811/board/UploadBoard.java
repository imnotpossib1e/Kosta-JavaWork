package ex0811.board;

/**
 * 자료실 게시판 속성 관리하는 객체
 */
public class UploadBoard extends Board {

    private String fileName;

    public UploadBoard() {
    }

    public UploadBoard(int no, String subject, String writer, String content, String fileName) {
        super(no, subject, writer, content);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append("fileName='").append(fileName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
