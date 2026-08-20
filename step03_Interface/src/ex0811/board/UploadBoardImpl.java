package ex0811.board;

public class UploadBoardImpl implements BoardService {

    @Override
    public int insert(Board board) {
        System.out.println(super.getClass().getSimpleName() + "의 insert call..");
        System.out.println("전달된 board = " + board);
        return 0;
    }

    @Override
    public boolean update(Board board) {
        System.out.println(super.getClass().getSimpleName() + "의 insert call..");
        System.out.println("전달된 board = " + board);
        return false;
    }

    @Override
    public Board selectByNo(int no) {
        System.out.println(super.getClass().getSimpleName() + "의 insert call..");
        System.out.println("전달된 no = " + no);
        return new UploadBoard(no, "파일 첨부", "하이", "안녕", "dd.jpg");
    }
}
