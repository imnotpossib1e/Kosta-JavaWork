package ex0811.board;

public class QaBoardServiceImpl implements BoardService {

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
        return new QaBpard(no, "졸리다", "하하", "아아", false);
    }
}
