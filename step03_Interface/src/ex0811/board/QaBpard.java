package ex0811.board;

/**
 * 질의 응답 게시판 속성 관리하는 객체
 */
public class QaBpard extends Board {

    private boolean replyState; // 답변 여부

    public QaBpard() {
    }

    public QaBpard(int no, String subject, String writer, String content, boolean replyState) {
        super(no, subject, writer, content);
        this.replyState = replyState;
    }

    public boolean isReplyState() {
        return replyState;
    }

    public void setReplyState(boolean replyState) {
        this.replyState = replyState;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append("replyState=").append(replyState);
        sb.append('}');
        return sb.toString();
    }
}